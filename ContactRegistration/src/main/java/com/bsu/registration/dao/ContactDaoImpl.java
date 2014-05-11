package com.bsu.registration.dao;

import com.bsu.registration.model.Contact;

import java.util.*;

/**
 * @author gbondarchuk
 */
public class ContactDaoImpl implements ContactDao {
    private Map<Long, Contact> repository = new HashMap<>();

    @Override
    public void save(Contact contact) {
        Long id = contact.getId();
        if (id == null) {
            throw new IllegalArgumentException("Detached entity passed to persist");
        }
        repository.put(id, contact);
    }

    @Override
    public void delete(Long id) {
        if (!repository.containsKey(id)) {
            throw new IllegalArgumentException("Entity not found");
        }
        repository.remove(id);
    }

    @Override
    public Contact update(Contact contact) {
        Long id = contact.getId();
        if (id == null) {
            throw new IllegalArgumentException("Transient entity passed to persist");
        }
        Contact old = repository.get(id);
        old.setFirstName(contact.getFirstName());
        old.setLastName(contact.getLastName());
        old.setCompanyName(contact.getCompanyName());
        old.setHobby(contact.getHobby());
        return old;
    }

    @Override
    public Contact load(Long id) {
        Contact contact = repository.get(id);
        if (contact == null) {
            throw new IllegalArgumentException("Entity not found");
        }
        return contact;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Contact> find() {
        Iterator iterator = repository.entrySet().iterator();
        List<Contact> contacts = new ArrayList<>();
        while (iterator.hasNext()) {
            Map.Entry pair = (Map.Entry) iterator.next();
            contacts.add((Contact) pair.getValue());
        }
        return contacts;
    }

    @Override
    public int count() {
        return repository.size();
    }

    @Override
    public void beginTransaction() {
        //begin transaction and clear local repository
    }

    @Override
    public void commitTransaction() {
        //Commit runtime repository to database.
    }
}
