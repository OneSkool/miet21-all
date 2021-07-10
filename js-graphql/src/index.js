"use strict";

const Fastify = require("fastify");
const mercurius = require("mercurius");
const UserGraphService = require("./user/UserGraphService");

//const app = Fastify()
let server;

function build() {
  const fastify = Fastify({ trustProxy: true });
  return fastify;
}

async function start() {
  // Google Cloud Run will set this environment variable for you, so
  // you can also use it to detect if you are running in Cloud Run
  const IS_GOOGLE_CLOUD_RUN = process.env.K_SERVICE !== undefined;

  // You must listen on the port Cloud Run provides
  const port = process.env.PORT || 3000;

  // You must listen on all IPV4 addresses in Cloud Run
  const ip = IS_GOOGLE_CLOUD_RUN ? "0.0.0.0" : undefined;

  try {
    server = build();
    const address = await server.listen(port, ip);
    console.log(`Listening on ${address}`);
  } catch (err) {
    console.error(err);
    process.exit(1);
  }
}

if (require.main === module) {
  start();
}

const schema = `
  type Query {
    add(x: Int, y: Int): Int
    users: [User]
  }
  type Mutation {
    addUser(name: String): User
  }
  type User { 
    id: String, 
    name: String 
}  
`;

const resolvers = {
  Query: {
    users: async (_, req) => {
      console.log("Getting users");
      let data = UserGraphService.users();
      return data;
    },
  },

  Mutation: {
    addUser: async (_, req) => {
      let { name } = req;
      console.log("Adding user " + name);
      return UserGraphService.addUser(name);
    },
  },
};

server.register(mercurius, {
  schema,
  resolvers,
  graphiql: true,
});

// server.get('/', async function (req, reply) {
//   const query = '{ add(x: 2, y: 2) }'
//   return reply.graphql(query)
// })

server.get("/", async function (req, reply) {
  const query = req.body;
  console.log("Query === " + query);
  return reply.graphql(query);
});
