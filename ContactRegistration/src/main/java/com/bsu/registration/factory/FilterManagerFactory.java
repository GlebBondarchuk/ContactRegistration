package com.bsu.registration.factory;

import com.bsu.registration.filter.FilterManager;
import com.bsu.registration.filter.FilterManagerImpl;

/**
 * @author gbondarchuk
 */
public class FilterManagerFactory {
    private static volatile FilterManager instance;

    public static FilterManager getInstance() {
        FilterManager localInstance = instance;
        if (localInstance == null) {
            synchronized (FilterManager.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new FilterManagerImpl();
                }
            }
        }
        return localInstance;
    }
}
