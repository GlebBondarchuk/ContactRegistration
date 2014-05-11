package com.bsu.registration.utils;

import com.bsu.registration.helper.XslPage;
import com.bsu.registration.view.PageModel;
import com.thoughtworks.xstream.XStream;
import org.xml.sax.InputSource;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

/**
 * @author gbondarchuk
 */
public class XslTransformer {
    public static void transformToXml(XslPage page, PageModel model, OutputStream responseOutputStream) {
        InputStream xsltFile = XslTransformer.class.getClassLoader().getResourceAsStream(page.getClassPath());

        XStream xStream = new XStream();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        xStream.toXML(model, outputStream);
        InputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());

        SAXSource saxSource = new SAXSource(new InputSource(new InputStreamReader(inputStream)));
        Source xsltSource = new StreamSource(xsltFile);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        try {
            Transformer transformer = transformerFactory.newTransformer(xsltSource);
            transformer.transform(saxSource, new StreamResult(responseOutputStream));
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
