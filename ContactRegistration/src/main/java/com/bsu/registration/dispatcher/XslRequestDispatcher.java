package com.bsu.registration.dispatcher;

import com.bsu.registration.helper.XslDispatcherHelper;
import com.bsu.registration.view.PageModel;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author gbondarchuk
 */
public class XslRequestDispatcher implements RequestDispatcher {
    @Override
    public void forward(ServletRequest request, ServletResponse response, PageModel pageModel, boolean result) {
        XslDispatcherHelper.dispatch(response, pageModel, result);
    }
}
