package com.avdbearing.repositories;

import com.avdbearing.domain.core.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
    Brand findBrandByBrandName(String brandName);
}
