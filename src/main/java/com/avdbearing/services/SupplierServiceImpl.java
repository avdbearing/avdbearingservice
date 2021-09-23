package com.avdbearing.services;


import com.avdbearing.domain.core.Supplier;
import com.avdbearing.dto.SupplierCreateDto;
import com.avdbearing.dto.SupplierDto;
import com.avdbearing.mappers.BusinessMapper;
import com.avdbearing.repositories.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class SupplierServiceImpl implements SupplierService {
    @Resource
    private SupplierRepository supplierRepository;
    @Resource
    private BusinessMapper businessMapper;
    @Resource
    private AddressRepository addressRepository;
    @Resource
    private ContactRepository contactRepository;

    @Override
    public List<SupplierDto> getAll() {
        List<Supplier> suppliers = supplierRepository.findAll();

        return businessMapper.convertToSupplierListDto(suppliers);
    }

    @Override
    public SupplierDto addSupplier(SupplierCreateDto supplierCreateDto) {
        Supplier supplier = businessMapper.convertToSupplierEntity(supplierCreateDto);

        addressRepository.save(supplier.getContact().getAddress());
        contactRepository.save(supplier.getContact());
        supplierRepository.save(supplier);

        return businessMapper.convertToSupplierDto(supplier);
    }

    @Override
    public void checkSupplier(Supplier supplier) {

    }


    @Override
    public void deleteSupplierById(long id) {
        supplierRepository.deleteById(id);
    }

    @Override
    public SupplierDto getSupplierById(long id) {

        Supplier currentSupplier = supplierRepository.findById(id).orElseThrow();

        System.out.println(businessMapper.convertToSupplierDto(currentSupplier));

        return businessMapper.convertToSupplierDto(currentSupplier);
    }

    @Override
    public void updateSupplier(SupplierDto supplierDto) {

        System.out.println(supplierDto);

        Supplier entitySupplier = businessMapper.convertToSupplier(supplierDto);
        System.out.println(entitySupplier);

        addressRepository.save(entitySupplier.getContact().getAddress());
        contactRepository.save(entitySupplier.getContact());
        supplierRepository.save(entitySupplier);


    }
}
