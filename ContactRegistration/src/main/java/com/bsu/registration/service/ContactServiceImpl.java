package com.bsu.registration.service;

import com.bsu.registration.dao.ContactDao;
import com.bsu.registration.factory.ContactDaoFactory;
import com.bsu.registration.model.Contact;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gbondarchuk
 */
public class ContactServiceImpl implements ContactService {
    private ContactDao contactDao = ContactDaoFactory.getInstance();

    @Override
    public void save(Contact contact) {
        contactDao.save(contact);
    }

    @Override
    public void delete(Long id) {
        contactDao.delete(id);
    }

    @Override
    public Contact update(Contact contact) {
        return contactDao.update(contact);
    }

    @Override
    public Contact load(Long id) {
        return contactDao.load(id);
    }

    @Override
    public List<Contact> find() {
        return contactDao.find();
    }

    @Override
    public List<Contact> find(int first, int last) {
        List<Contact> contacts = contactDao.find();
        List<Contact> source = new ArrayList<>();
        int size = contacts.size();
        if (first == size && last == size) {
            first = size - 1;
            last = size - 1;
        }
        for (int i = first; i <= last; ++i) {
            source.add(contacts.get(i));
        }
        return source;
    }

    @Override
    public int count() {
        return contactDao.count();
    }
}
