package com.avdbearing.services;

import com.avdbearing.domain.core.Brand;
import com.avdbearing.dto.BrandCreateDto;
import com.avdbearing.dto.BrandDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BrandService {
    BrandDto addBrand(BrandCreateDto brandCreateDto);

    void checkBrand(Brand brand);

    BrandDto getBrandById(long id);

    void updateBrand(BrandDto brandDto);


    void deleteBrandById(long id);

    List<BrandDto> getAll();

    void save(Brand brand);

    long getTotal();

    Page<Brand> findPaginated(int pageNumber, int pageSize, String sortField, String sortDirection);


}
