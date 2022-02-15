package com.avdbearing.services;


import com.avdbearing.domain.core.Part;
import com.avdbearing.domain.core.Supplier;
import com.avdbearing.dto.SupplierCreateDto;
import com.avdbearing.dto.SupplierDto;
import org.springframework.data.domain.Page;

import java.util.List;


public interface SupplierService {

    SupplierDto addSupplier(SupplierCreateDto supplierCreateDto);


    void checkSupplier(Supplier supplier);

    SupplierDto getSupplierById(long id);

    void updateSupplier(SupplierDto supplierDto);

    void deleteSupplierById(long id);

    List<SupplierDto> getAll();
    void save(Supplier supplier);

    long getTotal();

    Page<Supplier> findPaginated(int pageNumber, int pageSize, String sortField, String sortDirection);
}
