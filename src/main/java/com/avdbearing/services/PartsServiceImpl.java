package com.avdbearing.services;

import com.avdbearing.domain.core.Part;
import com.avdbearing.dto.PartCreateDto;
import com.avdbearing.dto.PartDto;
import com.avdbearing.mappers.BusinessMapper;
import com.avdbearing.repositories.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PartsServiceImpl implements PartService {
    @Resource
    private PartRepository partRepository;
    @Resource
    private BusinessMapper businessMapper;


    @Override
    public List<PartDto> getAll() {

        List<Part> parts = partRepository.findAll();


        return businessMapper.convertToPartListDto(parts);
    }


    @Override
    public void addPart(PartCreateDto partCreateDto) {


    }

    @Override
    public void checkInventory(Part article) {

    }

    @Override
    public void updatePart(PartCreateDto partCreateDto) {

    }

    @Override
    public void deletePart(String article) {

    }
}
