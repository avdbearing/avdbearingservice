package com.avdbearing.repositories;

import com.avdbearing.domain.core.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    public Supplier findByCompanyName(String companyName);

}
