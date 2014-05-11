package com.bsu.registration.helper;

import com.bsu.registration.handler.Action;
import com.bsu.registration.handler.PaginationDirection;
import com.bsu.registration.view.PageModel;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

import static com.bsu.registration.utils.Constants.*;

/**
 * @author gbondarchuk
 */
public class HttpRequestHelper {
    public static PageModel getPageModel(HttpServletRequest request) {
        PageModel pageModel = new PageModel();
        pageModel.getCurrent().setFirstName(request.getParameter(FIRST_NAME));
        pageModel.getCurrent().setLastName(request.getParameter(LAST_NAME));
        pageModel.getCurrent().setCompanyName(request.getParameter(COMPANY_NAME));
        pageModel.getCurrent().setHobby(request.getParameter(HOBBY));
        pageModel.setRequestUrl(request.getRequestURL().toString());
        Object position = request.getAttribute(POSITION);
        if (position != null) {
            pageModel.setPosition((int)position);
        }
        String direction = (String)request.getAttribute(DIRECTION);
        if (StringUtils.isNotBlank(direction)) {
            pageModel.setDirection(PaginationDirection.valueOf(direction));
        }
        String id = request.getParameter(FORM_ID);
        if (StringUtils.isNotBlank(id)) {
            pageModel.getCurrent().setId(Long.valueOf(id));
        }
        String action = (String) request.getAttribute(ACTION);
        if (StringUtils.isBlank(action)) {
            action = request.getParameter(ACTION);
        }
        if (StringUtils.isNotBlank(action)) {
            pageModel.setAction(Action.valueOf(action));
        }
        return pageModel;
    }
}
