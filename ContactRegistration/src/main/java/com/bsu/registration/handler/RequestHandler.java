package com.bsu.registration.handler;

import com.bsu.registration.view.PageModel;

/**
 * @author gbondarchuk
 */
public interface RequestHandler {
    boolean handleRequest(PageModel pageModel);
}
