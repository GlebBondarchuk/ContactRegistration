package com.bsu.registration.utils;

import com.bsu.registration.helper.XslPage;
import com.bsu.registration.view.PageModel;
import org.junit.Test;

/**
 * @author gbondarchuk
 */
public class XslTransformerTest {
    @Test
    public void transformTest() {
        PageModel pageModel = new PageModel();
        pageModel.setRequestUrl("/registration");
        XslPage[] pages = XslPage.values();
        for (XslPage page : pages) {
            XslTransformer.transformToXml(page, pageModel, System.out);
        }
    }
}
