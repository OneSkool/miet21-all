const Service = require('../restapi/user/UserService')

let restRoutes = (server) => {
    // App health check
    server.get('/ping', (req, res, next) => {
        res.send("Pong. OK at " + new Date());
        return next();
    });
    
    // User routes
    server.get('/users', (req, res, next) => {
        try {
            res.send(Service.users())
        } catch (err) {
           res.send(err.message) 
        } finally {
            next()
        }
    });
    server.post('/users', (req, res, next) => {
        let user = req.body
        console.log("User in route " + user);
        res.send(201, Service.addUser(user));
    })

    // Other routes ...


} 

module.exports = restRoutes