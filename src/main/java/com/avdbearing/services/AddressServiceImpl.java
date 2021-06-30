package com.avdbearing.services;

import com.avdbearing.domain.Address;
import com.avdbearing.domain.User;
import com.avdbearing.repositories.AddressRepository;
import com.avdbearing.repositories.UserRepository;

import javax.annotation.Resource;
import java.util.List;

public class AddressServiceImpl implements AddressService {

    @Resource
    private AddressRepository addressRepository;
    @Resource
    private UserRepository userRepository;

    @Override
    public void addAddress(Address address, User manager) {

    }

    @Override
    public List<Address> getAll() {
        return null;
    }

    @Override
    public void updateAddress(Address address, User manager) {

    }

    @Override
    public void deleteAddress(Address address, User manager) {

    }
}
