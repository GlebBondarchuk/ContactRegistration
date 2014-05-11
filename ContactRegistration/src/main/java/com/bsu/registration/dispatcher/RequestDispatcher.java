package com.bsu.registration.dispatcher;

import com.bsu.registration.view.PageModel;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author gbondarchuk
 */
public interface RequestDispatcher {
    void forward(ServletRequest request, ServletResponse response, PageModel pageModel, boolean result);
}
