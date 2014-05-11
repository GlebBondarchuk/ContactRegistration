package com.bsu.registration.filter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @author gbondarchuk
 */
public interface FilterManager {
    void filter(ServletRequest request, ServletResponse response) throws IOException, ServletException;
    void addFilter(Filter filter);
}
