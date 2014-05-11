package com.bsu.registration.controller;

import com.bsu.registration.dispatcher.RequestDispatcher;
import com.bsu.registration.dispatcher.XslRequestDispatcher;
import com.bsu.registration.factory.HandlerFactory;
import com.bsu.registration.handler.RequestHandler;
import com.bsu.registration.helper.HttpRequestHelper;
import com.bsu.registration.view.PageModel;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author gbondarchuk
 */
public class FrontController {
    private RequestDispatcher dispatcher = new XslRequestDispatcher();

    public void service(ServletRequest request, ServletResponse response) throws IOException, ServletException {

        PageModel pageModel = HttpRequestHelper.getPageModel((HttpServletRequest) request);
        RequestHandler handler = HandlerFactory.getInstance(pageModel);
        boolean result = handler.handleRequest(pageModel);
        dispatcher.forward(request, response, pageModel, result);
    }
}
