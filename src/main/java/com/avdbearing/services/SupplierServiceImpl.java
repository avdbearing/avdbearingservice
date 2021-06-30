package com.avdbearing.services;

import com.avdbearing.domain.Contact;
import com.avdbearing.domain.User;
import com.avdbearing.domain.core.Supplier;
import com.avdbearing.repositories.ContactRepository;
import com.avdbearing.repositories.UserRepository;

import javax.annotation.Resource;
import java.util.List;

public class SupplierServiceImpl implements SupplierService {
    @Resource
    private UserRepository userRepository;
    @Resource
    private ContactRepository contactRepository;

    @Override
    public void addSupplier(Supplier supplier, Contact contact, User manager) {

    }

    @Override
    public void updateSupplier(Supplier supplier, Contact contact, User manager) {

    }

    @Override
    public void deleteSupplier(Supplier company_name, User manager) {

    }

    @Override
    public List<Supplier> getAll() {
        return null;
    }
}
