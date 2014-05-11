package com.bsu.registration.utils;

/**
 * @author gbondarchuk
 */
public final class IdGenerator {
    public static Long generateNext() {
        return System.currentTimeMillis();
    }
}
