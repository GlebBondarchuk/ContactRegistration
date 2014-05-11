package com.bsu.registration.handler;

import com.bsu.registration.factory.ContactServiceFactory;
import com.bsu.registration.model.Contact;
import com.bsu.registration.service.ContactService;
import com.bsu.registration.utils.IdGenerator;
import com.bsu.registration.view.PageModel;

import static com.bsu.registration.handler.Action.*;

/**
 * @author gbondarchuk
 */
@Handler(REGISTRATION)
public class ActionRequestHandler implements RequestHandler {

    private ContactService contactService = ContactServiceFactory.getInstance();

    @Override
    public boolean handleRequest(PageModel pageModel) {
        Contact contact = pageModel.getCurrent();
        Long id = contact.getId();
        if (id == null) {
            id = IdGenerator.generateNext();
            contact.setId(id);
            contactService.save(contact);
        } else {
            contactService.update(contact);
        }
        return true;
    }
}
