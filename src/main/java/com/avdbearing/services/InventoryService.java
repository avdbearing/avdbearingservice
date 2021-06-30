package com.avdbearing.services;

import com.avdbearing.domain.Client;
import com.avdbearing.domain.User;
import com.avdbearing.domain.core.Part;
import com.avdbearing.domain.core.Supplier;

public interface InventoryService {

    void income(Part part, int amount, User manager, Supplier supplier);

    void salePart(Part part, int amount, User manager, Client client);

    void returnPart(Part part, int amount, User manager, Client client);

    void returnPartSupplier(Part part, int amount, User manager, Supplier supplier);


}
