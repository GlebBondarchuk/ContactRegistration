package com.bsu.registration.filter;

import com.bsu.registration.handler.PaginationDirection;
import com.bsu.registration.utils.Constants;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author gbondarchuk
 */
public class PaginationFilter implements Filter {
    @Override
    public void filter(ServletRequest request, ServletResponse response) {
        String direction = request.getParameter(Constants.DIRECTION);
        if (StringUtils.isNotBlank(direction)) {
            int position = Integer.valueOf(request.getParameter(Constants.POSITION));
            PaginationDirection paginationDirection = PaginationDirection.valueOf(direction);
            if (PaginationDirection.LEFT.equals(paginationDirection)) {
                int value = position - Constants.ITEMS_PER_PAGE;
                request.setAttribute(Constants.POSITION, value < 0 ? 0 : value);
            } else {
                request.setAttribute(Constants.POSITION, position + Constants.ITEMS_PER_PAGE);
            }

        }
    }
}
