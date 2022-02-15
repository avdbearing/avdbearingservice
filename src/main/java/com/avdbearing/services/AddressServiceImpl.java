package com.avdbearing.services;

import com.avdbearing.domain.Address;
import com.avdbearing.domain.User;
import com.avdbearing.domain.core.Supplier;
import com.avdbearing.mappers.BusinessMapper;
import com.avdbearing.repositories.AddressRepository;
import com.avdbearing.repositories.UserRepository;
import org.apache.commons.math3.analysis.function.Add;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.annotation.Resource;
import java.util.List;

public class AddressServiceImpl implements AddressService {

    @Resource
    private AddressRepository addressRepository;
    @Resource
    private BusinessMapper businessMapper;


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

    @Override
    public void save(Address address) {
        addressRepository.save(address);
    }

    @Override
    public long getTotal() {

        return addressRepository.count();
    }

    @Override
    public Page<Address> findPaginated(int pageNumber, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortField).ascending() : Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, sort);
        return addressRepository.findAll(pageable);
    }
}
