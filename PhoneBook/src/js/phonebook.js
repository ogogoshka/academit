$(document).ready(function () {

var userNumber = 1;

    var table = $('.main-table');
    table
        .on('change', '> tbody input:checkbox', function () {
            $(this).closest('span').toggleClass('checked', $(this).is(':checked'));
        })
        .on('change', '#all', function () {
            $('> tbody input:checkbox', table).prop('checked', $(this).is(':checked')).trigger('change');
        });

    var reorderRows = function () {
        var rows = $(".main-table").find("tbody").find("tr");
        userNumber = rows.length + 1;
        $(rows).each(function (i) {
            $(this).find("td").eq(1).text(i + 1);
        })
    };


    $(".delete-user-from-table").on("click", function () {
        var checked = $("input:checkbox:checked").map(function () {
            //var checked = $("#check").is(":checked").map(function () {
            return this.value;
        }).get();

        if (confirm("Вы действительно хотите удалить эти контакты?")) {
            $("#check:checked").parents("tr").remove();
            reorderRows();
        }

    });

    function confirmDelete(deleteCell) {

        var currentSurname = deleteCell.closest("tr").find("td").eq(2).html();
        var currentName = deleteCell.closest("tr").find("td").eq(3).html();

        if (confirm("Вы действительно  хотите удалить контакт : " + currentSurname + " " + currentName)) {

            deleteCell.closest("tr").remove();
            reorderRows();
        }
    }

    function checkDuplicateNumbers(phoneNumber) {
        var isHasDuplicates = false;

        var phoneColumn = $(".main-table").find("tbody").find("tr");
        if (userNumber == 1) {
            return false;
        } else {
            $(phoneColumn).each(function () {
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
            $(".input-fields").addClass("empty-fields");
            surname = "";
            name = "";
            phoneNumber = "";
            valid = false;
        }
        else {
            $(".input-fields").removeClass("empty-fields");

        }

        $("b.err").remove();
        if (!valid) {
            $("div.error-message").append("<b class='err'>Нужно заполнить все поля</b>");
        }
        return valid;
    }

    $(".add-user-to-table").click(function () {
        var surname = $("#my-surname").val();//GETTER
        var name = $("#my-name").val();//GETTER
        var phoneNumber = $("#my-phone").val();//GETTER

        surname = $.trim(surname);
        name = $.trim(name);
        phoneNumber = $.trim(phoneNumber);

        console.log("surname = " + surname);
        console.log("name = " + name);
        console.log("phoneNumber = " + phoneNumber);

        var newRow = $("<tr><td></td><td></td><td></td><td></td><td></td><td></td></tr>");

        newRow.find("td").eq(0).html("<span><input type='checkbox' id='check'/></span>");
        newRow.find("td").eq(1).text(userNumber);
        newRow.find("td").eq(2).text(surname);
        newRow.find("td").eq(3).text(name);
        newRow.find("td").eq(4).text(phoneNumber);
        newRow.find("td").eq(5).html("<input type='button' value='&times;' class='remove-user-cell'/>");

        newRow.find("td").eq(5).click(function () {
            confirmDelete($(this));
        });

        if (checkInputFields()) {
            var isHasDuplicate = checkDuplicateNumbers(phoneNumber);
            if (isHasDuplicate) {
                $("div.error-message").append("<b class='err'>Этот номер уже есть в списке!!!</b>");
            } else if (!$.isNumeric(phoneNumber)) {
                $("div.error-message").append("<b class='err'>Некорректный телефон. В поле телефон нужно вводить цифры!!!</b>");
            } else {
                $(".main-table").append(newRow);
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

    $(".apply-filter-button").click(function () {
        var filter = $(".filter-field").val().toLowerCase();
        filter = $.trim(filter);

        $(".main-table").find("tbody").find("tr").each(function () {
            if (filter == "") {
                $(".main-table").find("tbody").find("tr").each(function () {
                    $('tbody tr').removeClass('visible').show().addClass('visible');
                    $(this).show();
                });
            } else {

                if ($(this).find("td:nth-child(3)").text().search(filter) < 0) {
                    if ($(this).find("td:nth-child(4)").text().search(filter) < 0) {
                        if ($(this).find("td:nth-child(5)").text().search(filter) < 0) {
                            $(this).hide();
                        }
                    }
                } else {
                    $(this).show()
                }

            }

        });

    });

    $(".reset-filter-button").click(function () {
        $(".filter-field").val("");
        $(".main-table").find("thead").find("tr").show();
        $(".main-table").find("tbody").find("tr").each(function () {
            $(this).show();
        });
    });

});
