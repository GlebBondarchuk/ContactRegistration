package com.bsu.registration.handler;

import com.bsu.registration.factory.ContactServiceFactory;
import com.bsu.registration.service.ContactService;
import com.bsu.registration.service.UnitOfWorkService;
import com.bsu.registration.service.UnitOfWorkServiceImpl;
import com.bsu.registration.view.PageModel;

import static com.bsu.registration.handler.Action.SAVE_CONTACT;

/**
 * @author gbondarchuk
 */
@Handler(SAVE_CONTACT)
public class ContactsRequestHandler implements RequestHandler {

    private ContactService contactService = ContactServiceFactory.getInstance();
    private UnitOfWorkService unitOfWorkService = new UnitOfWorkServiceImpl();

    @Override
    public boolean handleRequest(PageModel pageModel) {
        unitOfWorkService.commitTransaction();
        return true;
    }
}
