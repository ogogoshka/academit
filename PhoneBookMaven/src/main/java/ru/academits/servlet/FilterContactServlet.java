package ru.academits.servlet;

import ru.academits.PhoneBook;
import ru.academits.coverter.ContactConverter;
import ru.academits.coverter.ContactValidationConverter;
import ru.academits.model.Contact;
import ru.academits.service.ContactService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;

public class FilterContactServlet extends HttpServlet {
    private ContactService phoneBookService = PhoneBook.phoneBookService;
    private ContactConverter contactConverter = PhoneBook.contactConverter;
    private ContactValidationConverter contactValidationConverter = PhoneBook.contactValidationConverter;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Contact> contactList = phoneBookService.getAllContacts();
        String[] myArray = req.getParameterValues("myArray[]");

        if (myArray != null) {
            List<Contact> filteredContactList = new ArrayList<>();
            Contact filteredContact = new Contact();
            for (String aMyArray : myArray) {
                filteredContact.setId(Integer.valueOf(aMyArray));
                Iterator<Contact> contactIterator = contactList.iterator();
                while (contactIterator.hasNext()) {
                    Contact myContact = contactIterator.next();
                    if (filteredContact.getId() == myContact.getId()) {
                        filteredContactList.add(myContact);
                    }
                }

            }
            String contactListJson = contactConverter.convertToJson(filteredContactList);
            resp.getOutputStream().write(contactListJson.getBytes(Charset.forName("UTF-8")));
            resp.getOutputStream().flush();
            resp.getOutputStream().close();
        } else {
            String contactListJson = contactConverter.convertToJson(contactList);
            resp.getOutputStream().write(contactListJson.getBytes(Charset.forName("UTF-8")));
            resp.getOutputStream().flush();
            resp.getOutputStream().close();
        }


    }
}