let IdGenerator = require('short-uuid')
 
let userData = []

let UserService = {
    users: ()=> {
        return userData
    },

    addUser: (user) => {
        let userObj = JSON.parse(user)
        userObj.id = IdGenerator.generate()
        userData = [...userData, userObj]
        return userObj
    }
}

module.exports = UserService