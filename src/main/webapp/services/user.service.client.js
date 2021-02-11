// USER SERVICE FUNCTION
function AdminUserServiceClient() {
    this.createUser = createUser;
    this.findAllUsers = findAllUsers;
    this.findUserById = findUserById;
    this.deleteUser = deleteUser;
    this.updateUser = updateUser;
    this.url = 'https://wbdv-generic-server.herokuapp.com/api/apizzoccheri/users';
    var self = this;

    /**
    * CREATE NEW USER
    */
    function createUser(user) {
      return fetch(self.url, {
        method: 'POST',
        headers: {
          'content-type': 'application/json'
        },
        body: JSON.stringify(user)
      }).then(function (response) {
        return response.json()
      })
     }


    function findUserById(userId) {}

    /**
    * UPDATE USER
    */
    function updateUser(userId, user) {}

    /**
    * DELETE USER
    */
    function deleteUser(userId) {
      return fetch(`${self.url}/${userId}`,
        {
          method: 'DELETE'
        })
    }

    /**
    * FIND ALL USERS
    */
    function findAllUsers() {
      return fetch(self.url).then(function(response) {
        return response.json();
      });
    }
}
