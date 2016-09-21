$(document).ready(function () {
    var userNumber = 1;

    var reorderRows = function () {
        var rows = $(".main-table").find("tbody").find("tr");
        userNumber = rows.length + 1;
        $(rows).each(function (i) {
            $(this).find("td").eq(1).text(i + 1);
        })
    };

    $(".main-table").find("#select-all-checkboxes").click(function () {
        var selectedCheckboxes = $(".main-table").find("tbody").find(".select-row").filter(":visible");
        selectedCheckboxes.prop('checked', $(this).prop("checked"));
        var visibleCheckboxes = selectedCheckboxes.filter(":checked").filter(":visible");
        $("#delete-button").prop("disabled", false);
        $('#delete-button').removeClass('non-active-button');

        if ($("#select-all-checkboxes").is(":not(:checked)") && visibleCheckboxes.length === 0) {
            $("#delete-button").prop("disabled", true);
            $('#delete-button').addClass('non-active-button');
        }
    });


    $('.delete-user-from-table').click(function () {
        var selectedCheckboxes = $(".main-table").find("tbody").find(".select-row");
        var visibleCheckboxes = selectedCheckboxes.filter(":checked").filter(":visible");

        var deletedContacts = "";
        $(visibleCheckboxes).each(function () {
            var deletedSurname = $(this).parents("tr").find("td:nth-child(3)").text();
            var deletedName = $(this).parents("tr").find("td:nth-child(4)").text();
            deletedContacts += deletedSurname + " " + deletedName + "<br>";
        });

        if (visibleCheckboxes.length > 0) {
            $.confirm({
                'title': 'Подтверждение',
                'message': 'Вы действительно хотите удалить эти контакты?<br>' + deletedContacts,
                'buttons': {
                    'ДА': {
                        'class': 'blue',
                        'action': function () {
                            $(visibleCheckboxes).closest("tr").remove();
                            $("#select-all-checkboxes").prop("checked", false);
                            $('#delete-button').addClass('non-active-button');
                            $("#delete-button").prop("disabled", true);
                            reorderRows();
                        }
                    },
                    'НЕТ': {
                        'class': 'gray',
                        'action': function () {
                        }
                    }
                }
            });
        }

    });

    function confirmDelete(deleteCell) {
        var currentSurname = deleteCell.closest("tr").find("td").eq(2).html();
        var currentName = deleteCell.closest("tr").find("td").eq(3).html();

        $.confirm({
            'title': 'Подтверждение',
            'message': 'Вы действительно  хотите удалить контакт : <br>' + currentSurname + " " + currentName,
            'buttons': {
                'ДА': {
                    'class': 'blue',
                    'action': function () {
                        deleteCell.closest("tr").remove();
                        reorderRows();
                    }
                },
                'НЕТ': {
                    'class': 'gray',
                    'action': function () {
                    }
                }
            }
        });
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

        var newRow = $("<tr><td></td><td></td><td></td><td></td><td></td><td></td></tr>");

        newRow.find("td").eq(0).html("<input type='checkbox' class='select-row'/>");
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

        $(".main-table").find("tbody").find("input:checkbox").change(function () {
            var selectedCheckboxes = $(".main-table").find(".select-row").filter(":checked").filter(":visible");
            $("#select-all-checkboxes").prop("checked", false);
            if (selectedCheckboxes.length > 0) {
                $("#delete-button").prop("disabled", false);
                $('#delete-button').removeClass('non-active-button');
            } else {
                $("#delete-button").prop("disabled", true);
                $('#delete-button').addClass('non-active-button');
            }
        });

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
                var findSurname = $(this).find("td:nth-child(3)").text().toLowerCase();
                var findName = $(this).find("td:nth-child(4)").text().toLowerCase();
                var findPhone = $(this).find("td:nth-child(5)").text().toLowerCase();

                if (findSurname.toLowerCase().indexOf(filter) < 0) {
                    if (findName.toLowerCase().indexOf(filter) < 0) {
                        if (findPhone.toLowerCase().indexOf(filter) < 0) {
                            $(this).hide();
                            enableDisableDeleteButton();
                        }
                    }
                } else {
                    $(this).show();
                    enableDisableDeleteButton();
                }
            }
        });
    });

//сброс фильтра - очистка поля
    $(".reset-filter-button").click(function () {
        $(".filter-field").val("");
        $(".main-table").find("thead").find("tr").show();
        $(".main-table").find("tbody").find("tr").each(function () {
            $(this).show();
            enableDisableDeleteButton();
        });
    });

    function enableDisableDeleteButton() {
        var selectedCheckboxes = $(".main-table").find(".select-row").filter(":checked").filter(":visible");
        if (selectedCheckboxes.length > 0) {
            $("#delete-button").prop("disabled", false);
            $('#delete-button').removeClass('non-active-button');
        } else {
            $("#delete-button").prop("disabled", true);
            $('#delete-button').addClass('non-active-button');
        }
    }

});
