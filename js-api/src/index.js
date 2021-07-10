var restify = require('restify');
 
const server = restify.createServer({
  name: 'one-eateries',
  version: '1.0.0'
});
 
server.use(restify.plugins.acceptParser(server.acceptable));
server.use(restify.plugins.queryParser());
server.use(restify.plugins.bodyParser());
server.use(restify.plugins.gzipResponse())
 
/**
 * Add routes
 */
require('./config/routes')(server)

/** 
 * Handle all errors
 */
server.on("NotFound", (req, res, err, callback) => {
    err.toJSON = function customToJSON() {
        return {
            name: err.name,
            message: "Resource not found. Send email at errors@oneeateries.com"
        };
    };
    return callback();
})

/**
 * Start server
 */
server.listen(8080, function () {
  console.log('%s listening at %s', server.name, server.url);
});