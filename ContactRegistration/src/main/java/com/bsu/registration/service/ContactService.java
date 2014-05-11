package com.bsu.registration.service;

import com.bsu.registration.model.Contact;

import java.util.List;

/**
 * @author gbondarchuk
 */
public interface ContactService {
    void save(Contact contact);

    void delete(Long id);

    Contact update(Contact contact);

    Contact load(Long id);

    List<Contact> find();

    List<Contact> find(int first, int last);

    int count();
}
