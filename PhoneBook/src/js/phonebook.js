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
            //var checked = $("#check").is(":checked").map(function () {
            return this.value;
        }).get();


        //var deleteList = $("#check:checked").closest("tr").find("td").eq(2).get();
        //console.log("deleteList = " + deleteList);

        if (confirm("Вы действительно хотите удалить эти контакты?")) {
            $("#check:checked").parents("tr").remove();
            reordersRow();
        }

        //$("#check").is(":checked").parents("tr").remove();
        //$("input:checkbox:checked").parents("tr").remove();


        //$("#all").attr("checked","checked");
        //$(".mainTable tr:first-child").find("input#all").removeAttr("checked");

    });

    function confirmDelete(deleteCell) {
        //row.closest("tr").find("td").eq(3);
        //console.log(row.closest("tr").find("td").eq(3));
        //var familia  = row.closest("tr").find("td")[3];
        //var imya  = row.closest("tr").find("td")[4];

        //var ff = row.closest("tr").find("td")[2];
        //console.log($("td").text(ff));
        //$(row).(function () {


        //var isMarried = $("#check").is(":checked");
        //console.log(isMarried);


        //$(".mainTable tr").find("#check").each(function () {
        //if ($(this).attr("checked")) {
        //$(this).attr("checked", true);
        //console.log("allilyia");

        //}
        //});
        $(".mainTable tr").each(function () {
            //var ff = $(this).find("td").eq(0).html();
            //var ff = $(this).find("td").eq(0);
            //var isMarried = $("#check").is(":checked");
            var isMarried = $(this).find("#check").is(":checked");
            //ff.find("span");
            //console.log(ff);
            //console.log(ff.find("span"));
            if (isMarried) {
                console.log(isMarried);
            }
        });


        /*
         $(".mainTable tr").each(function () {
         //var ff = $(this).find("td").eq(0);
         //            $(this).find("#check").attr("checked",false)
         //ff.attr("checked", true);
         //console.log("ff = " + ff);
         if ($(this).find("#check").attr("checked", true)) {
         console.log("allilyia");
         //console.log("ff = " + ff);
         }
         });
         */


        var currentSurname = deleteCell.closest("tr").find("td").eq(2).html();
        var currentName = deleteCell.closest("tr").find("td").eq(3).html();

        //console.log("row = " + row.closest("tr").find("td").eq(2).html());

        //var ff = row.closest("tr").find("td")[2];

        //console.log("ff = " + ff);
        //console.log(row.closest("tr").find("td")[2]);
        //console.log(row.closest("tr").find("td")[3]);
        var res = confirm("Вы действительно  хотите удалить контакт : " + currentSurname + " " + currentName);
        if (res) {
            deleteCell.closest("tr").remove();
            reordersRow();
        }
    }

    //var surname = "";
    //var name = "";
    //var phoneNumber = "";


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
            //$("form").addClass(".inputField");
            //$("input").addClass(".inputField input:focus");
            //$(".inputField").css("border", "2px solid black");
            //$(".mainForm input:focus").css("border-color", "#07a6e6");
            //$(".inputField input:focus").css("border-color", "#07a6e6");

            //outline: none;
            //border-color: #07a6e6;
            //border-radius: 10px;

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


        //cells.eq(1).text;
        //cells.eq(2);
        //cells.eq(3);
        //cells.eq(4);
        //cells.eq(5);


        if (checkInputFields()) {
            /*
             var row = '<tr id=' + userNumber
             + '><td><span><input type="checkbox" /></span></td><td>'
             + userNumber + '</td><td>'
             + surname + '</td><td>' + name + '</td><td>'
             + phoneNumber
             + '</td><td><input type="button" onclick ="confirmDelete($(this))" value="&times;" class="removeUser" /></td></tr>';

             */

            //onclick ="confirmDelete($(this))"
            //user_id="' + userNumber + '"
            //text = $(row).text();


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

                //$(".mainTable").click(function () {


                //$(".mainTable").find(".removeUser").click(function () {
                //var res = confirm("Вы действительно хотите удалить этого пользователя?");
                //if (res) {
                //$(this).closest("tr").remove();
                //row.closest('tr').remove();
                //reordersRow();
                //}

                //});
                //});


                //$(".removeUser").click(function () {


                //var res = confirm("Вы действительно хотите удалить этого пользователя?");
                //console.log("res=" + res);

                //if (res) {
                //$(this).closest("tr").remove();
                //row.closest('tr').remove();
                //reordersRow();
                //return false;
                //}
                //confirmDelete($(this));
                //$(this).closest("tr").remove();
                //});

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
