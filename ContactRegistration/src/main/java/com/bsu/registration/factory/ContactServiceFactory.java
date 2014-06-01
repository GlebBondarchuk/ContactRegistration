package com.bsu.registration.factory;

import com.bsu.registration.service.ContactService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Double checked locking singleton.
 *
 * @author gbondarchuk
 */
public class ContactServiceFactory {
    private static final String CONTACT_SERVICE_BEAN_NAME = "contactService";

    private static ApplicationContext context =
            new FileSystemXmlApplicationContext("classpath:/spring/applicationContext.xml");

    private static volatile ContactService instance;

    public static ContactService getInstance() {
        ContactService localInstance = instance;
        if (localInstance == null) {
            synchronized (ContactService.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = (ContactService) context.getBean(CONTACT_SERVICE_BEAN_NAME);
                }
            }
        }
        return localInstance;
    }
}
