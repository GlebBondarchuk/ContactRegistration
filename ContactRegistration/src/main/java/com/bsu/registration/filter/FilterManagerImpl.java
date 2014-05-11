package com.bsu.registration.filter;

import com.bsu.registration.factory.FilterChainFactory;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @author gbondarchuk
 */
public class FilterManagerImpl implements FilterManager {

    private FilterChain filterChain = FilterChainFactory.getInstance();

    @Override
    public void filter(ServletRequest request, ServletResponse response) throws IOException, ServletException {
        filterChain.filter(request, response);
    }

    @Override
    public void addFilter(Filter filter) {
        filterChain.addFilter(filter);
    }
}
