package com.bsu.registration.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author gbondarchuk
 */
public interface FilterChain {
    void filter(ServletRequest request, ServletResponse response);
    void addFilter(Filter filter);
}
