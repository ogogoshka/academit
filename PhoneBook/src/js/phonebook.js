var userNumber = 1;

var reordersRow = function () {
    var rows = $(".mainTable").find("tbody").find("tr");
    userNumber = rows.length + 1;
    $(rows).each(function (i) {
        $(this).find("td").eq(1).text(i + 1);
    })
};

function confirmDelete(row) {
    var res = confirm("Вы действительно хотите удалить этого пользователя?");
    if (res) {
        row.closest('tr').remove();
        reordersRow();
    }
}

$(document).ready(function () {
    var surname = "";
    var name = "";
    var phoneNumber = "";

    function checkDuplicateNumbers(phoneNumber) {
        var isHasDuplicates = false;

        var col = $(".mainTable").find("tbody").find("tr");
        if (userNumber == 1) {
            return false;
        } else {
            $(col).each(function () {
                if (phoneNumber == $(this).find("td").eq(4).text()) {
                    isHasDuplicates = true;
                }
            });
        }
        return isHasDuplicates;
    }

    function checkInputFields() {
        //получаем значение полей
        surname = $("#my-surname").val();
        name = $("#my-name").val();
        phoneNumber = $("#my-phone").val();
        var valid = true;

        if (surname == "" || name == "" || phoneNumber == "") {
            $(".inputField").css("border", "2px solid red");
            surname = "";
            name = "";
            phoneNumber = "";
            valid = false;
        } else {
            $(".inputField").css("border", "2px solid black");
        }

        $('b.err').remove();
        if (!valid) {
            $('div.errorMessage').append('<b class="err">Нужно заполнить все поля</b>');
        }
        return valid;
    }

    $('.addUser').click(function () {
        surname = $("#my-surname").val();//GETTER
        name = $("#my-name").val();//GETTER
        phoneNumber = $("#my-phone").val();//GETTER

        console.log("surname = " + surname);
        console.log("name = " + name);
        console.log("phoneNumber = " + phoneNumber);

        if (checkInputFields()) {
            var row = '<tr id=' + userNumber
                + '><td><span><input type="checkbox" /></span></td><td>'
                + userNumber + '</td><td>'
                + surname + '</td><td>' + name + '</td><td>'
                + phoneNumber
                + '</td><td><input type="button" value="&times;" class="removeUser" /></td></tr>';
            //onclick ="confirmDelete($(this))"
            //user_id="' + userNumber + '"
            //text = $(row).text();
            console.log("row = " + row);
            var bool = checkDuplicateNumbers(phoneNumber);
            console.log("bool=" + bool);
            if (bool) {
                $('div.errorMessage').append('<b class="err">Этот номер уже есть в списке!!!</b>');
            } else {
                $('.mainTable').append(row);

                $("#my-surname").val("");   //SETTER
                $("#my-name").val("");      //SETTER
                $("#my-phone").val("");     //SETTER
                ++userNumber;

                $(".removeUser").click(function () {
                    //var res = confirm("Вы действительно хотите удалить этого пользователя?");
                    //console.log("res=" + res);

                    //if (res) {
                    //$(this).closest("tr").remove();
                    //row.closest('tr').remove();
                    //reordersRow();
                    //return false;
                    //}
                    confirmDelete($(this));
                    //$(this).closest("tr").remove();
                });

            }


        } else {
            surname = "";
            name = "";
            phoneNumber = "";
        }
    });


});

$(document).ready(function () {
    var table = $('.mainTable');
    table
        .on('change', '> tbody input:checkbox', function () {
            $(this).closest('span').toggleClass('checked', $(this).is(':checked'));
        })
        .on('change', '#all', function () {
            $('> tbody input:checkbox', table).prop('checked', $(this).is(':checked')).trigger('change');
        });
});
