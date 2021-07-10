let IdGenerator = require('short-uuid')
 
let userData = [
    {"id": "1", "name": "Shailender"},
    {"id": "2", "name": "Rajiv"},
]


let UserGraphService = {
    users: () => {
        return userData
    },

    addUser: (user) => {
        let userObj = {"name": user}
        userObj.id = IdGenerator.generate()
        userData = [...userData, userObj]
        return userObj
    }
}

module.exports = UserGraphService