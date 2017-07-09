function Contact(firstName, lastName, phone) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.phone = phone;
}

function delete_checked_rows() {
    var arr = [];
    $("table.contact-table").find("tbody").find("input.select-me:checked").each(function () {
        $(this).closest("tr").remove();
        re_row();
        var $row_attr = $(this).closest("tr").attr("id");
        $row_attr = $row_attr.split("_");
        var $id = $row_attr[1];
        arr.push($id);
    });
    return arr;
}

function print_contacts() {
    var $content = "";
    $("table.contact-table").find("tbody").find("input.select-me").each(function () {
        if ($(this).is(":checked")) {
            console.log($(this).closest("tr").find("td").eq(2).text());
            var $lastname = $(this).closest("tr").find("td").eq(2).text();
            var $firstname = $(this).closest("tr").find("td").eq(3).text();
            var $phone = $(this).closest("tr").find("td").eq(4).text();
            $content = $content + "</br>" + $lastname + " " + $firstname + " " + $phone;
        }
    });
    return $content;
}

function click_main_checkbox() {
    $("div.alert").empty();
    $("body").find("label.select-all-label").find("input[type=checkbox]").on("click", function () {
        if ($(this).is(":checked")) {
            $(this).closest("table").find("tbody").find("input[type=checkbox]").each(function (index) {
                $(this).prop('checked', true);
            });
        } else {
            $(this).closest("table").find("tbody").find("input[type=checkbox]").each(function (index) {
                $(this).prop('checked', false);
            });
        }
    });
}

function click_checkbox() {
    $("div.alert").empty();
    $("table.contact-table").find("label.select-me-label").each(function () {
        $(this).find("input[type=checkbox]").on("click", function () {
            if ($(this).is(":checked")) {
                $(this).prop("checked", true);
            } else {
                $(this).prop("checked", false);
                $(this).closest("table").find("thead").find("input[type=checkbox]").prop("checked", false);
            }
        });
    });
}

function re_row() {
    $("table.contact-table").find("tbody").find("tr").each(function (index) {
        $(this).find("td").eq(1).empty();
        $(this).find("td").eq(1).append(index + 1);
    });
}

function row_builder(id, lastName, firstName, phone) {
    lastName = '<td data-bind="text: lastName" class="user-info">' + lastName + '</td>';
    firstName = '<td data-bind="text: firstName" class="user-info">' + firstName + '</td>';
    phone = '<td data-bind="text: phone" class="user-info">' + phone + '</td>';

    var $current_row = '<tr id="userID_' + id + '" data-bind="if: shown"><td><label class="select-me-label"><input type="checkbox" class="select-me"></label></td>';
    $current_row = $current_row + '<td data-bind="text: number"></td>';
    $current_row = $current_row + lastName + firstName + phone;
    $current_row = $current_row + '<td><button class="btn btn-primary delete-current-row" type="button">Удалить</button></td></tr></tr>';

    return $current_row;
}

function filter_rows(searchQuery) {
    var arr = [];
    $("table.contact-table").find("tbody").find("tr").each(function () {
        $(this).find("td.user-info").each(function () {
            if ($(this).text().toLowerCase().indexOf(searchQuery.toLowerCase()) > -1) {
                console.log($(this).text());
                var $row_attr = $(this).closest("tr").attr("id");
                $row_attr = $row_attr.split("_");
                var $id = $row_attr[1];
                arr.push($id);
                return false;
            }
        });
    });
    return arr;
}

$(document).ready(function () {
    $("div.alert").empty();
    click_checkbox();
    click_main_checkbox();
    re_row();

    $("input.user-phone").onkeypress = function (event) {
        return !(/\D/.test(String.fromCharCode(event.charCode)));
    };

    $.ajax({
        type: "GET",
        url: "/phonebook/get/all",
        success: function (result) {
            var res = JSON.parse(result);
            $.each(res, function () {
                $("table.contact-table").find("tbody").append(row_builder(this.id, this.lastName, this.firstName, this.phone));
            });
            re_row();
        }
    });

    $("button.add-contact").on("click", function () {
        $("div.alert").empty();

        var $user_secondname = $("form.form").find("input.user-secondname").val();
        var $user_firstname = $("form.form").find("input.user-firstname").val();
        var $user_phone = $("form.form").find("input.user-phone").val();

        var contact = new Contact($user_firstname, $user_secondname, $user_phone);

        var empty_fields = 0;

        $("form.form").find("input").each(function (index) {
            $("span.error-message").eq(index).empty();
            if (!$(this).val()) {
                var field_name = "";
                empty_fields++;
                switch (index) {
                    case 0:
                        field_name = "Фамилия";
                        break;
                    case 1:
                        field_name = "Имя";
                        break;
                    case 2:
                        field_name = "Телефон";
                        break;
                }
                $("span.error-message").eq(index).append("Поле " + field_name + " должно быть заполнено.");
            }
        });

        if (empty_fields > 0) {
            return;
        }

        $("form.form").find("input.user-secondname").val("");
        $("form.form").find("input.user-firstname").val("");
        $("form.form").find("input.user-phone").val("");

        $user_secondname = '<td data-bind="text: lastName">' + $user_secondname + '</td>';
        $user_firstname = '<td data-bind="text: firstName">' + $user_firstname + '</td>';
        $user_phone = '<td data-bind="text: phone">' + $user_phone + '</td>';
        /*
         var $current_row = '<tr data-bind="if: shown"><td><label class="select-me-label"><input type="checkbox" class="select-me"></label></td>';
         $current_row = $current_row + '<td data-bind="text: number"></td>';
         $current_row = $current_row + $user_secondname + $user_firstname + $user_phone;
         $current_row = $current_row + '<td><button class="btn btn-primary delete-current-row" type="button">Удалить</button></td></tr></tr>';
         */
        $.ajax({
            type: "POST",
            url: "/phonebook/add",
            data: JSON.stringify(contact)
        }).done(function () {
            //self.serverValidation(false);
        }).fail(function (ajaxRequest) {
            //var contactValidation = $.parseJSON(ajaxRequest.responseText);
            //self.serverError(contactValidation.error);
            //self.serverValidation(true);
        }).always(function () {

            $.ajax({
                type: "GET",
                url: "/phonebook/get/all",

                success: function (result) {
                    var res = JSON.parse(result);
                    $("table.contact-table").find("tbody").empty();
                    $.each(res, function () {
                        $("table.contact-table").find("tbody").append(row_builder(this.id, this.lastName, this.firstName, this.phone));
                    });
                    re_row();
                }
            });

        });

        click_checkbox();
        click_main_checkbox();
        re_row();
    });

    $("button.apply-filter").on("click", function () {
        $("div.alert").empty();
        console.log("apply filter");
        var $searchQuery = $("input.filter").val();
        console.log("$searchQuery = " + $searchQuery);
        var $myArray = filter_rows($searchQuery);
        console.log("$myArray = " + $myArray);

        $.ajax({
            type: "GET",
            url: "/phonebook/filter",
            data: {myArray: $myArray},
            success: function (result) {
                var res = JSON.parse(result);
                $("table.contact-table").find("tbody").empty();
                $.each(res, function () {
                    $("table.contact-table").find("tbody").append(row_builder(this.id, this.lastName, this.firstName, this.phone));
                });
                re_row();
            }
        });

    });

    $("button.reset-filter").on("click", function () {
        $("div.alert").empty();
        $("input.filter").val("");
        $.ajax({
            type: "GET",
            url: "/phonebook/get/all",
            success: function (result) {
                var res = JSON.parse(result);
                $.each(res, function () {
                    $("table.contact-table").find("tbody").append(row_builder(this.id, this.lastName, this.firstName, this.phone));
                });
                re_row();
            }
        });
    });

    $("table.contact-table").on("click", "button.delete-current-row", function () {
        $("div.alert").empty();

        var $id = $(this).closest("tr").attr("id");
        $id = $id.split("_");

        var $user_id = $id[1];

        var $lastname = $(this).closest("tr").find("td").eq(2).text();
        var $firstname = $(this).closest("tr").find("td").eq(3).text();
        var $phone = $(this).closest("tr").find("td").eq(4).text();

        var $current_row = $(this).closest("tr");

        var content = "Вы уверены, что хотите удалить контакт:</br>" + $lastname + " " + $firstname + " " + $phone + " " + "?";

        var $myArray = [];
        $myArray.push($user_id);

        $.confirm({
            'title': 'Delete Confirmation',
            'message': content,
            'buttons': {
                'Yes': {
                    'class': 'blue',
                    'action': function () {
                        $.ajax({
                            type: "POST",
                            url: "/phonebook/delete",
                            data: {myArray: $myArray},
                            success: function (result) {

                                $($current_row).remove();
                                re_row();

                                var res = JSON.parse(result);
                                $.each(res, function () {
                                    $("table.contact-table").find("tbody").append(row_builder(this.id, this.lastName, this.firstName, this.phone));
                                });

                            }
                        }).always(function () {
                            $.ajax({
                                type: "GET",
                                url: "/phonebook/get/all",
                                success: function (result) {
                                    var res = JSON.parse(result);
                                    $("table.contact-table").find("tbody").empty();

                                    $.each(res, function () {
                                        $("table.contact-table").find("tbody").append(row_builder(this.id, this.lastName, this.firstName, this.phone));
                                    });
                                    re_row();
                                }
                            });

                        });

                    }
                },
                'No': {
                    'class': 'gray',
                    'action': function () {
                    }
                }
            }
        });
    });

    $("div.content").on("click", "button.delete-checked-contacts", function () {
        $("div.alert").empty();
        var $count_rows = $("table.contact-table").find("tbody").find("input.select-me:checked").length;
        if ($count_rows == 0) {
            $("div.alert").append("Нет выбранных контактов");
            return;
        }

        if ($count_rows == 1) {
            $.confirm({
                'title': 'Delete Confirmation',
                'message': "Вы уверены, что хотите удалить контакт:" + print_contacts() + " ?",
                'buttons': {
                    'Yes': {
                        'class': 'blue',
                        'action': function () {
                            var $myArray = delete_checked_rows();
                            $.ajax({
                                type: "POST",
                                url: "/phonebook/delete",
                                data: {myArray: $myArray},
                                success: function (result) {

                                    var res = JSON.parse(result);
                                    $.each(res, function () {
                                        $("table.contact-table").find("tbody").append(row_builder(this.id, this.lastName, this.firstName, this.phone));
                                    });
                                    re_row();

                                }
                            });
                        }
                    },
                    'No': {
                        'class': 'gray',
                        'action': function () {
                        }
                    }
                }
            });
        } else {
            $.confirm({
                'title': 'Delete Confirmation',
                'message': "Вы уверены, что хотите удалить контакты:" + print_contacts() + " ?",
                'buttons': {
                    'Yes': {
                        'class': 'blue',
                        'action': function () {
                            var $myArray = delete_checked_rows();

                            $.ajax({
                                type: "POST",
                                url: "/phonebook/delete",
                                data: {myArray: $myArray},
                                success: function (result) {

                                    var res = JSON.parse(result);
                                    $.each(res, function () {
                                        $("table.contact-table").find("tbody").append(row_builder(this.id, this.lastName, this.firstName, this.phone));
                                    });
                                    re_row();

                                }
                            }).always(function () {
                                $.ajax({
                                    type: "GET",
                                    url: "/phonebook/get/all",
                                    success: function (result) {
                                        var res = JSON.parse(result);
                                        $("table.contact-table").find("tbody").empty();

                                        $.each(res, function () {
                                            $("table.contact-table").find("tbody").append(row_builder(this.id, this.lastName, this.firstName, this.phone));
                                        });
                                        re_row();
                                    }
                                });

                            });

                        }
                    },
                    'No': {
                        'class': 'gray',
                        'action': function () {
                        }
                    }
                }
            });
        }
    });


});