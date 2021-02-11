var $usernameFld, $passwordFld;
var $firstNameFld, $lastNameFld, $roleFld;
var $removeBtn, $editBtn, $createBtn;
var $userRowTemplate, $tBody;
var users;
var userService = new AdminUserServiceClient();

var users = [];

/**
* CREATE NEW USER
*/
function createUser() {
  // new user JSON object
  var user = {
    username: $usernameFld.val(),
    password: $passwordFld.val(),
    first_name: $firstNameFld.val(),
    last_name: $lastNameFld.val(),
    role: $roleFld.val()
  }

  userService.createUser(user)
  .then(function (user) {
    // add new user to array
    users.push(user)

    // re-render users
    renderUsers(users);
  })
}

/**
* DELETE USER
*/
function deleteUser(e) {
  // get index
  var userIndex = e.target.dataset.index;
  // get user id
  var id = users[userIndex]._id;

  userService.deleteUser(id).then(function(status) {
    users.splice(userIndex, 1)

    // re-render users
    renderUsers(users)
  })
}

/**
* SELECT USER
*/
var selectedUser = null

function selectUser(e) {
  // get index
  var index = e.target.dataset.index;

  // get selected user
  selectedUser = users[index]

  $usernameFld.val(selectedUser.username)
  $passwordFld.val(selectedUser.password)
  $firstNameFld.val(selectedUser.first_name)
  $lastNameFld.val(selectedUser.last_name)
  $roleFld.val(selectedUser.role)

  // add classes to selected row
  $(e.target).parents('tr').addClass('is-selected is-editing');
}

/**
* UPDATE USER
*/
function updateUser(e) {

  // update user field values
  selectedUser.username = $usernameFld.val();
  selectedUser.password = $passwordFld.val();
  selectedUser.first_name = $firstNameFld.val();
  selectedUser.last_name = $lastNameFld.val();
  selectedUser.role = $roleFld.val();

  userService.updateUser(selectedUser._id, selectedUser)
    .then(function (status) {
      // find index of target user
      var index = users.findIndex(user => user._id === selectedUser._id)
      // update user
      users[index] = selectedUser

      // re-render users
      renderUsers(users)
    })
}

/**
* RENDER ALL USERS
*/
function renderUsers(all) {
  // empty table first
  $tBody.empty();

  // create table row for each user and append to form
  for (var i = 0; i < all.length; i++) {
    var user = all[i];
    // generate HTML
    $tBody.prepend(`
      <tr>
        <td>${user.username}</td>
        <td>${user.password}</td>
        <td>${user.first_name}</td>
        <td>${user.last_name}</td>
        <td>${user.role}</td>
        <td>
          <span class="js-actions">
            <button data-index=${i} class="btn btn-edit">Update</button>
            <button data-index=${i} class="btn btn-delete">Delete</button>
          </span>
        </td>
      </tr>
    `);
  }

  // bind click events
  $('.btn-edit').click(selectUser);
  $('.btn-delete').click(deleteUser);

  // reset input fields
  $('.table').find('.form-control').val('');
  $('.table').find('.form-control-dropdown').val('FACULTY');
}

// declare main() function used to evoke rest of functions
function main() {
  $tBody = $('#usersTable');
  $editBtn = $('.btn-okay');
  $createBtn = $('.btn-add');
  $usernameFld = $('#usernameFld');
  $passwordFld = $('#passwordFld');
  $firstNameFld = $('#firstNameFld');
  $lastNameFld = $('#lastNameFld');
  $roleFld = $('#roleFld');

  // bind click event
  $createBtn.click(() => {
    createUser();
  })

  // bind click event
  $editBtn.click((e) => {
    updateUser(e);
  })

  // generate all users
  userService.findAllUsers().then(function(actualUsers) {
    users = actualUsers;

    // render users
    renderUsers(users);
  });

}

$(main);