package com.avdbearing.services;


import com.avdbearing.domain.Contact;
import com.avdbearing.domain.User;
import com.avdbearing.domain.core.Part;
import com.avdbearing.domain.core.Supplier;

import java.util.List;


public interface SupplierService {

    void addSupplier(Supplier supplier, Contact contact, User manager);

    void updateSupplier(Supplier supplier, Contact contact, User manager);

    void deleteSupplier(Supplier company_name, User manager);

    List<Supplier> getAll();
}
