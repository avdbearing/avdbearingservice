package com.avdbearing.services;

import com.avdbearing.domain.Address;
import com.avdbearing.domain.User;
import com.avdbearing.domain.core.Part;
import com.avdbearing.domain.core.Supplier;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AddressService {

    void addAddress(Address address, User manager);

    void updateAddress(Address address, User manager);

    void deleteAddress(Address address, User manager);

    List<Address> getAll();
    void save(Address address);

    long getTotal();

    Page<Address> findPaginated(int pageNumber, int pageSize, String sortField, String sortDirection);
}
