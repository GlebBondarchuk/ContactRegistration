package com.bsu.registration.factory;

import com.bsu.registration.dao.ContactDao;
import com.bsu.registration.dao.ContactDaoImpl;

/**
 * Double checked locking singleton.
 *
 * @author gbondarchuk
 */
public class ContactDaoFactory{
    private static volatile ContactDao instance;

    public static ContactDao getInstance() {
        ContactDao localInstance = instance;
        if (localInstance == null) {
            synchronized (ContactDao.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new ContactDaoImpl();
                }
            }
        }
        return localInstance;
    }
}
