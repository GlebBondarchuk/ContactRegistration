package com.bsu.registration.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gbondarchuk
 */
public class FilterChainImpl implements FilterChain {

    private List<Filter> filters = new ArrayList<>();

    public FilterChainImpl(Filter... filters) {
        for (Filter filter : filters) {
            addFilter(filter);
        }
    }

    @Override
    public void addFilter(Filter filter) {
        filters.add(filter);
    }

    @Override
    public void filter(ServletRequest request, ServletResponse response) {
        for (Filter filter : filters) {
            filter.filter(request, response);
        }
    }
}
