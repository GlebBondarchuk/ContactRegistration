package com.bsu.registration.dao;

import com.bsu.registration.model.Contact;

import java.util.List;

/**
 * @author gbondarchuk
 */
public interface ContactDao {
    void save(Contact contact);

    void delete(Long id);

    Contact update(Contact contact);

    Contact load(Long id);

    List<Contact> find();

    int count();

    void beginTransaction();

    void commitTransaction();
}
