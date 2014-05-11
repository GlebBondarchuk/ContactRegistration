package com.bsu.registration.controller;

import com.bsu.registration.factory.FilterManagerFactory;
import com.bsu.registration.filter.FilterManager;
import com.bsu.registration.filter.PaginationFilter;
import com.bsu.registration.filter.SessionFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author gbondarchuk
 */
public class DispatcherServlet extends HttpServlet {
    private FilterManager filterManager;
    private FrontController controller = new FrontController();

    @Override
    public void init() throws ServletException {
        super.init();
        filterManager = FilterManagerFactory.getInstance();
        filterManager.addFilter(new SessionFilter());
        filterManager.addFilter(new PaginationFilter());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        filterManager.filter(request, response);
        controller.service(request, response);
    }
}
