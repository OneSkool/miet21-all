FROM node:13-alpine

# App directory inside container
WORKDIR /usr/js-graphql

# Copy package files
COPY package*.json ./

#Install depdendencies
RUN npm ci --only=production

#Copy build sources
ADD . ./

#Expose an internal port
EXPOSE 3000

# Run application
CMD ["npm", "start"]
