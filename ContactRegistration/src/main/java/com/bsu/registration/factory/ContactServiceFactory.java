package com.bsu.registration.factory;

import com.bsu.registration.service.ContactService;
import com.bsu.registration.service.ContactServiceImpl;

/**
 * Double checked locking singleton.
 *
 * @author gbondarchuk
 */
public class ContactServiceFactory {
    private static volatile ContactService instance;

    public static ContactService getInstance() {
        ContactService localInstance = instance;
        if (localInstance == null) {
            synchronized (ContactService.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new ContactServiceImpl();
                }
            }
        }
        return localInstance;
    }
}
