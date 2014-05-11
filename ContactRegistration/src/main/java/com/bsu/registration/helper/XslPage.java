package com.bsu.registration.helper;

/**
 * @author gbondarchuk
 */
public enum XslPage {
    ERROR("xsl/error.xsl"),
    REGISTRATION_PAGE("xsl/registration.xsl"),
    CONTACT_PAGE("xsl/contact.xsl"),
    SUCCESS("xsl/success.xsl");


    private String classPath;

    private XslPage(String classPath) {
        this.classPath = classPath;
    }

    public String getClassPath() {
        return classPath;
    }
}
