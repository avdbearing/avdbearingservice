package com.avdbearing.services;


import com.avdbearing.domain.core.Supplier;
import com.avdbearing.dto.SupplierCreateDto;
import com.avdbearing.dto.SupplierDto;

import java.util.List;


public interface SupplierService {

    void addSupplier(SupplierCreateDto supplierCreateDto);

    void updateSupplier(Supplier companyName);

    void checkSupplier(Supplier supplier);

    void deleteSupplier(Supplier companyName);

    List<SupplierDto> getAll();
}
