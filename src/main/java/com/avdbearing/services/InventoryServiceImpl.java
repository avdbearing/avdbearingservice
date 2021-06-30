package com.avdbearing.services;

import com.avdbearing.domain.Client;
import com.avdbearing.domain.User;
import com.avdbearing.domain.core.Part;
import com.avdbearing.domain.core.Supplier;
import com.avdbearing.repositories.ClientRepository;
import com.avdbearing.repositories.InventoryRepository;
import com.avdbearing.repositories.SupplierRepository;
import com.avdbearing.repositories.UserRepository;

import javax.annotation.Resource;

public class InventoryServiceImpl implements InventoryService {

    @Resource
    private UserRepository userRepository;
    @Resource
    private InventoryRepository inventoryRepository;
    @Resource
    private ClientRepository clientRepository;
    @Resource
    private SupplierRepository supplierRepository;

    @Override
    public void income(Part part, int amount, User manager, Supplier supplier) {

    }

    @Override
    public void salePart(Part part, int amount, User manager, Client client) {

    }

    @Override
    public void returnPart(Part part, int amount, User manager, Client client) {

    }

    @Override
    public void returnPartSupplier(Part part, int amount, User manager, Supplier supplier) {

    }
}
