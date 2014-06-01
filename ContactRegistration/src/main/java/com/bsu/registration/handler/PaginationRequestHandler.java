package com.bsu.registration.handler;

import com.bsu.registration.factory.ContactServiceFactory;
import com.bsu.registration.model.Contact;
import com.bsu.registration.service.ContactService;
import com.bsu.registration.utils.Constants;
import com.bsu.registration.view.PageModel;

import java.util.List;

import static com.bsu.registration.handler.Action.PAGINATION;

/**
 * @author gbondarchuk
 */
@Handler(PAGINATION)
public class PaginationRequestHandler implements RequestHandler {
    private ContactService contactService = ContactServiceFactory.getInstance();

    @Override
    public boolean handleRequest(PageModel pageModel) {
        int count = contactService.count();
        int position = pageModel.getPosition();
        if (position + Constants.ITEMS_PER_PAGE - 1 > count) {
            position = count - Constants.ITEMS_PER_PAGE + 1;
            pageModel.setPosition(position);
        }
        List<Contact> contacts = contactService.find(position, position + Constants.ITEMS_PER_PAGE - 1);
        pageModel.getContacts().addAll(contacts);
        return true;
    }
}
