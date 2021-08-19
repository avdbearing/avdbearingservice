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

    @Override
    public List<SupplierDto> getAll() {
        List<Supplier> suppliers = supplierRepository.findAll();

        return businessMapper.convertToSupplierListDto(suppliers);
    }

    @Override
    public void addSupplier(SupplierCreateDto supplierCreateDto) {

    }

    @Override
    public void checkSupplier(Supplier supplier) {

    }

    @Override
    public void updateSupplier(Supplier companyName) {

    }

    @Override
    public void deleteSupplier(Supplier companyName) {

    }

}
