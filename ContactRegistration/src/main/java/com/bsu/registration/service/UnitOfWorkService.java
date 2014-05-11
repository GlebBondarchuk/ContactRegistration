package com.bsu.registration.service;

/**
 * @author gbondarchuk
 */
public interface UnitOfWorkService {
    void beginTransaction();

    void commitTransaction();
}
