package com.bsu.registration.helper;

import com.bsu.registration.handler.Action;
import com.bsu.registration.utils.XslTransformer;
import com.bsu.registration.view.PageModel;

import javax.servlet.ServletResponse;
import java.io.IOException;

import static com.bsu.registration.handler.Action.*;

/**
 * @author gbondarchuk
 */
public class XslDispatcherHelper {
    public static void dispatch(ServletResponse response, PageModel pageModel, boolean result) {
        Action action = pageModel.getAction();
        XslPage page = null;
        if (!result) {
            page = XslPage.ERROR;
        } else if (action.equals(REGISTRATION) || action.equals(START)) {
            page = XslPage.REGISTRATION_PAGE;
        } else if (action.equals(SAVE_CONTACT)) {
            page = XslPage.SUCCESS;
        } else if (action.equals(PAGINATION)) {
            page = XslPage.CONTACT_PAGE;
        }

        try {
            XslTransformer.transformToXml(page, pageModel, response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
