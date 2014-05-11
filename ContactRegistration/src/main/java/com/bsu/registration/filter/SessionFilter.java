package com.bsu.registration.filter;

import com.bsu.registration.handler.Action;
import com.bsu.registration.utils.Constants;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author gbondarchuk
 */
public class SessionFilter implements Filter {
    @Override
    public void filter(ServletRequest request, ServletResponse response) {
        if (request.getParameter(Constants.ACTION) == null) {
            request.setAttribute(Constants.ACTION, Action.START.name());
        }
    }
}
