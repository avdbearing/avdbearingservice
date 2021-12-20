package com.avdbearing.services;

import com.avdbearing.domain.core.Brand;
import com.avdbearing.dto.BrandCreateDto;
import com.avdbearing.dto.BrandDto;
import com.avdbearing.mappers.BusinessMapper;
import com.avdbearing.repositories.BrandRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service

public class BrandServiceImpl implements BrandService {

    @Resource
    private BusinessMapper businessMapper;
    @Resource
    private BrandRepository brandRepository;

    @Override
    public List<BrandDto> getAll() {
        List<Brand> brands = brandRepository.findAll();

        return businessMapper.convertToBrandListDto(brands);
    }

    @Override
    public BrandDto addBrand(BrandCreateDto brandCreateDto) {
        Brand brand = businessMapper.convertToBrandEntity(brandCreateDto);

        brandRepository.save(brand);

        return businessMapper.convertToBrandDto(brand);

    }

    @Override
    public void checkBrand(Brand brand) {

    }

    @Override
    public void deleteBrandById(long id) {
        brandRepository.deleteById(id);
    }

    @Override
    public BrandDto getBrandById(long id) {

        Brand currentBrand = brandRepository.findById(id).orElseThrow();


        System.out.println(businessMapper.convertToBrandDto(currentBrand));

        return businessMapper.convertToBrandDto(currentBrand);
    }

    @Override
    public void updateBrand(BrandDto brandDto) {

        System.out.println(brandDto);

        Brand entityBrand = businessMapper.convertToBrand(brandDto);
        System.out.println(entityBrand);


        brandRepository.save(entityBrand);


    }



    @Override
    public void save(Brand brand) {
        brandRepository.save(brand);
    }

    @Override
    public long getTotal() {

        return brandRepository.count();
    }

    @Override
    public Page<Brand> findPaginated(int pageNumber, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortField).ascending() : Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, sort);
        return brandRepository.findAll(pageable);
    }

}
