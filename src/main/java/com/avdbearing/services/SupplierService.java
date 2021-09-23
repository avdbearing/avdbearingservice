package com.avdbearing.services;


import com.avdbearing.domain.core.Supplier;
import com.avdbearing.dto.SupplierCreateDto;
import com.avdbearing.dto.SupplierDto;

import java.util.List;


public interface SupplierService {

    SupplierDto addSupplier(SupplierCreateDto supplierCreateDto);


    void checkSupplier(Supplier supplier);

    SupplierDto getSupplierById(long id);

    void updateSupplier(SupplierDto supplierDto);

    void deleteSupplierById(long id);

    List<SupplierDto> getAll();
}
