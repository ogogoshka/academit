var userNumber = 1;


$(document).ready(function () {

    var reordersRow = function () {
        var rows = $(".mainTable").find("tbody").find("tr");
        userNumber = rows.length + 1;
        $(rows).each(function (i) {
            $(this).find("td").eq(1).text(i + 1);
        })
    };


    $(".ButtonForDeleteUser").on('click', function () {
        var checked = $("input:checkbox:checked").map(function () {

            return this.value;
        }).get();



        if (confirm("Вы действительно хотите удалить эти контакты?")) {
            $("#check:checked").parents("tr").remove();
            reordersRow();
        }


    });

    function confirmDelete(deleteCell) {


        var currentSurname = deleteCell.closest("tr").find("td").eq(2).html();
        var currentName = deleteCell.closest("tr").find("td").eq(3).html();


        var res = confirm("Вы действительно  хотите удалить контакт : " + currentSurname + " " + currentName);
        if (res) {
            deleteCell.closest("tr").remove();
            reordersRow();
        }
    }


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
        var surname = $("#my-surname").val();
        var name = $("#my-name").val();
        var phoneNumber = $("#my-phone").val();
        var valid = true;

        if (surname == "" || name == "" || phoneNumber == "") {
            //$(".inputField").css("border", "2px solid red");
            $(".inputField").addClass("empty_field");
            surname = "";
            name = "";
            phoneNumber = "";
            valid = false;
        }
        else {
            $(".inputField").removeClass("empty_field");

        }

        $('b.err').remove();
        if (!valid) {
            $('div.errorMessage').append('<b class="err">Нужно заполнить все поля</b>');
        }
        return valid;
    }

    $('.addUser').click(function () {
        var surname = $("#my-surname").val();//GETTER
        //surname = $("#my-surname").text();//GETTER
        var name = $("#my-name").val();//GETTER
        var phoneNumber = $("#my-phone").val();//GETTER

        surname = $.trim(surname);
        name = $.trim(name);
        phoneNumber = $.trim(phoneNumber);

        console.log("surname = " + surname);
        console.log("name = " + name);
        console.log("phoneNumber = " + phoneNumber);

        var newRow = $("<tr><td></td><td></td><td></td><td></td><td></td><td></td></tr>");
        //var cells = newRow.find("td");


        newRow.find("td").eq(0).html("<span><input type='checkbox' id='check'/></span>");
        newRow.find("td").eq(1).text(userNumber);
        newRow.find("td").eq(2).text(surname);
        newRow.find("td").eq(3).text(name);
        newRow.find("td").eq(4).text(phoneNumber);
        newRow.find("td").eq(5).html("<input type='button' value='&times;' class='removeUser'/>");

        newRow.find("td").eq(5).click(function () {
            confirmDelete($(this));
        });



        if (checkInputFields()) {


            console.log("row = " + newRow);
            var bool = checkDuplicateNumbers(phoneNumber);
            console.log("bool=" + bool);
            if (bool) {
                $('div.errorMessage').append('<b class="err">Этот номер уже есть в списке!!!</b>');
            } else if (!$.isNumeric(phoneNumber)) {
                $('div.errorMessage').append('<b class="err">Некорректный телефон. В поле телефон нужно вводить цифры!!!</b>');
            } else {

                $('.mainTable').append(newRow);

                //$('.mainTable').append(row);

                $("#my-surname").val("");   //SETTER
                $("#my-name").val("");      //SETTER
                $("#my-phone").val("");     //SETTER
                ++userNumber;

            }


        } else {
            surname = "";
            name = "";
            phoneNumber = "";
        }
    });

    var table = $('.mainTable');
    table
        .on('change', '> tbody input:checkbox', function () {
            $(this).closest('span').toggleClass('checked', $(this).is(':checked'));
        })
        .on('change', '#all', function () {
            $('> tbody input:checkbox', table).prop('checked', $(this).is(':checked')).trigger('change');
        });

});

$(document).ready(function () {

});
