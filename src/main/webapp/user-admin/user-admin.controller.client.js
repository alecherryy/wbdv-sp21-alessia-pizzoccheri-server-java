var $usernameFld, $passwordFld;
var $firstNameFld, $lastNameFld, $roleFld;
var $removeBtn, $editBtn, $createBtn;
var $userRowTemplate, $tBody;
var users;
// var userService = new AdminUserServiceClient();

var users = [];

/**
* CREATE NEW USER
*/
function createUser() {
  // DOM el selector
  var user = {
    username: $usernameFld.val(),
    password: $passwordFld.val(),
    first_name: $firstNameFld.val(),
    last_name: $lastNameFld.val(),
    role: $roleFld.val()
  }

  // add new user to array
  users.push(user);

  // re-render users
  renderUsers(users);
}

/**
* DELETE USER
*/
function deleteUser(e) {
  // get index
  var index = e.target.dataset.index;
  users.splice(index, 1);

  // re-render users
  renderUsers(users);
}

/**
* SELECT USER
*/
var index = null;
function selectUser(e) {
  index = e.target.dataset.index;
  var selectedUser = users[index];

  $usernameFld.val(selectedUser.username);
  $passwordFld.val(selectedUser.password);
  $firstNameFld.val(selectedUser.first_name);
  $lastNameFld.val(selectedUser.last_name);
  $roleFld.val(selectedUser.role);

  // add classes to selected row
  $(e.target).parents('tr').addClass('is-selected is-editing');
}

/**
* UPDATE USER
*/
function updateUser(e) {
  // get index
  var id = index;

  // update user
  users[id].username = $usernameFld.val();
  users[id].password = $passwordFld.val();
  users[id].first_name = $firstNameFld.val();
  users[id].last_name = $lastNameFld.val();
  users[id].role = $roleFld.val();

  // re-render users
  renderUsers(users);
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

  $createBtn.click(() => {
    createUser();
  })

  $editBtn.click((e) => {
    updateUser(e);
  })

  renderUsers(users);
}

$(main);