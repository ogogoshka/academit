$(document).ready(function () {
    var userNumber = 0;
    var surname = "";
    var name = "";
    var phoneNumber = "";

    function check() {
        var f = document.forms.mainForm;
        var valid = false;
        for (var i = 0; i < f.length; i++) {
            if (f.elements[i].type = "text") {
                if (f.elements[i].value == "") {
                    f.elements[i].style.borderColor = "red";
                    valid = true;
                    surname = "";
                    name = "";
                    phoneNumber = "";
                }
                else {
                    f.elements[i].style.borderColor = "";
                }
            }
        }
        return valid;
    }

    //var surname = "Ivanov";
    //var name = "Ivan";
    //var phoneNumber = "8-913-444-5599";
    var row = "";

    $('.addUser').click(function () {

        surname = $("#my-surname").val();//GETTER
        name = $("#my-name").val();//GETTER
        phoneNumber = $("#my-phone").val();//GETTER

        if (!check()) {

            userNumber++;
            row += '<tr id=' + userNumber
                + '><td>'
                + userNumber + '</td><td>'
                + surname + '</td><td>'
                + name + '</td><td>'
                + phoneNumber
                + '</td><td><input onclick="confirmDelete();" type="button" value="X" class="removeUser" user_id="' + userNumber + '"/></td></tr>';
            //onclick="return confirmDelete();"

            $('#mainTable').append(row);
            row = "";
            $("#my-surname").val("");//SETTER
            $("#my-name").val("");//SETTER
            $("#my-phone").val("");//SETTER

        } else {
            surname = "";
            name = "";
            phoneNumber = "";
        }


    });
});

function confirmDelete() {
    var res = confirm("Вы действительно хотите удалить этого пользователя?");
    console.log("res=" + res);
    if (res) {
        deleteUser();
    }
}

function deleteUser() {
    $('#mainTable').delegate('.removeUser', 'click', function () {
        var id = $(this).attr('user_id');
        $('#' + id).remove();
    });
}
