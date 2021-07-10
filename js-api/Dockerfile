FROM node:13-alpine

# App directory inside container
WORKDIR /usr/js-api

# Copy package files
COPY package*.json ./

#Install depdendencies
RUN npm ci --only=production

#Copy build sources
ADD . ./

#Expose an internal port
EXPOSE 8080

# Run application
CMD ["npm", "start"]
