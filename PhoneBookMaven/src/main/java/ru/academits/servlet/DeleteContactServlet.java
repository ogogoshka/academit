package ru.academits.servlet;

import ru.academits.PhoneBook;
import ru.academits.coverter.ContactConverter;
import ru.academits.coverter.ContactValidationConverter;
import ru.academits.dao.ContactDao;
import ru.academits.model.Contact;
import ru.academits.service.ContactService;
import ru.academits.service.ContactValidation;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class DeleteContactServlet extends HttpServlet {
    private ContactService phoneBookService = PhoneBook.phoneBookService;
    private ContactConverter contactConverter = PhoneBook.contactConverter;
    private ContactValidationConverter contactValidationConverter = PhoneBook.contactValidationConverter;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Contact> contactList = phoneBookService.getAllContacts();
        String[] myArray = req.getParameterValues("myArray[]");

        Contact userContact = new Contact();

        for (String aMyArray : myArray) {
            userContact.setId(Integer.valueOf(aMyArray));
            //contactList.removeIf(contact -> userContact.getId() == contact.getId());
            Iterator<Contact> contactIterator = contactList.iterator();
            while (contactIterator.hasNext()) {
                if (userContact.getId() == contactIterator.next().getId()) {
                    contactIterator.remove();
                }
            }
        }

        String contactListJson = contactConverter.convertToJson(contactList);
        resp.getOutputStream().write(contactListJson.getBytes(Charset.forName("UTF-8")));
        resp.getOutputStream().flush();
        resp.getOutputStream().close();

    }
}
