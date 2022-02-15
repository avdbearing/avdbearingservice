package com.avdbearing.services;


import com.avdbearing.domain.core.Brand;
import com.avdbearing.domain.core.Part;
import com.avdbearing.dto.PartCreateDto;
import com.avdbearing.dto.PartDto;
import com.avdbearing.mappers.BusinessMapper;
import com.avdbearing.repositories.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PartsServiceImpl implements PartService {
    @Resource
    private PartRepository partRepository;
    @Resource
    private BusinessMapper businessMapper;
    @Resource
    private SizeRepository sizeRepository;
    @Resource
    private SupplierRepository supplierRepository;
    @Resource
    private BrandRepository brandRepository;


    @Override
    public List<PartDto> getAll() {

        List<Part> parts = partRepository.findAll();


        return businessMapper.convertToPartListDto(parts);
    }

    @Override
    public void deletePartById(long id) {
        partRepository.deleteById(id);
    }

    @Override
    public PartDto addPart(PartCreateDto partCreateDto) {
        Part part = businessMapper.convertToPartEntity(partCreateDto);

        supplierRepository.save(part.getSupplier());
        sizeRepository.save(part.getSize());
        brandRepository.save(part.getBrand());
        partRepository.save(part);


        return businessMapper.convertToPartDto(part);
    }

    @Override
    public void checkInventory(Part article) {

    }

    @Override
    public void updatePart(PartDto partDto) {

        System.out.println(partDto);

        Part entityPart = businessMapper.convertToPart(partDto);
        System.out.println(entityPart);

        sizeRepository.save(entityPart.getSize());
        supplierRepository.save(entityPart.getSupplier());
        brandRepository.save(entityPart.getBrand());
        partRepository.save(entityPart);


    }


    @Override
    public PartDto getPartById(long id) {

        Part currentPart = partRepository.findById(id).orElseThrow();

        System.out.println(businessMapper.convertToPartDto(currentPart));

        return businessMapper.convertToPartDto(currentPart);
    }

    @Override
    public void save(Part part) {
        partRepository.save(part);
    }

    @Override
    public long getTotal() {

        return partRepository.count();
    }

    @Override
    public Page<Part> findPaginated(int pageNumber, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortField).ascending() : Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, sort);
        return partRepository.findAll(pageable);
    }

}
