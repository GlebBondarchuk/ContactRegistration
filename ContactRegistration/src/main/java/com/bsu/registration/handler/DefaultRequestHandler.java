package com.bsu.registration.handler;

import com.bsu.registration.service.UnitOfWorkService;
import com.bsu.registration.service.UnitOfWorkServiceImpl;
import com.bsu.registration.view.PageModel;

import static com.bsu.registration.handler.Action.*;

/**
 * @author gbondarchuk
 */
@Handler(START)
public class DefaultRequestHandler implements RequestHandler {

    private UnitOfWorkService unitOfWorkService = new UnitOfWorkServiceImpl();

    @Override
    public boolean handleRequest(PageModel pageModel) {
        unitOfWorkService.beginTransaction();
        return true;
    }
}
