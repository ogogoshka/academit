package ru.academits.dao;

import ru.academits.model.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ContactDao {
    private List<Contact> contactList = new ArrayList<>();
    private AtomicInteger idSequence = new AtomicInteger(0);

    public ContactDao() {
        Contact contact = new Contact();
        contact.setId(getNewId());
        contact.setFirstName("Иван");
        contact.setLastName("Иванов");
        contact.setPhone("9123456789");
        contactList.add(contact);

        Contact contact2 = new Contact();
        contact2.setId(getNewId());
        contact2.setFirstName("Петр");
        contact2.setLastName("Петров");
        contact2.setPhone("9113456711");
        contactList.add(contact2);

        Contact contact3 = new Contact();
        contact3.setId(getNewId());
        contact3.setFirstName("Василий");
        contact3.setLastName("Васильев");
        contact3.setPhone("9991156711");
        contactList.add(contact3);
    }

    private int getNewId() {
        return idSequence.addAndGet(1);
    }

    public List<Contact> getAllContacts() {
        return contactList;
    }

    public void add(Contact contact) {
        contactList.add(contact);
    }

    public void delete(Contact contact) {
    }

    public Contact find(Contact contact) {
        return null;
    }

}