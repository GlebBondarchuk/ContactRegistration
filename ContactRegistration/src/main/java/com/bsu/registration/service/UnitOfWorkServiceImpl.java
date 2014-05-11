package com.bsu.registration.service;

import com.bsu.registration.dao.ContactDao;
import com.bsu.registration.factory.ContactDaoFactory;

/**
 * @author gbondarchuk
 */
public class UnitOfWorkServiceImpl implements UnitOfWorkService {
    private ContactDao contactDao = ContactDaoFactory.getInstance();

    @Override
    public void beginTransaction() {
        contactDao.beginTransaction();
    }

    @Override
    public void commitTransaction() {
        contactDao.commitTransaction();
    }
}
