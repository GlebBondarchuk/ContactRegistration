package com.bsu.registration.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author gbondarchuk
 */
public interface Filter {
    void filter(ServletRequest request, ServletResponse response);
}
