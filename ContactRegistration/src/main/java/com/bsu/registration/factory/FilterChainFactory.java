package com.bsu.registration.factory;

import com.bsu.registration.filter.FilterChain;
import com.bsu.registration.filter.FilterChainImpl;

/**
 * @author gbondarchuk
 */
public class FilterChainFactory {
    private static volatile FilterChain instance;

    public static FilterChain getInstance() {
        FilterChain localInstance = instance;
        if (localInstance == null) {
            synchronized (FilterChain.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new FilterChainImpl();
                }
            }
        }
        return localInstance;
    }
}
