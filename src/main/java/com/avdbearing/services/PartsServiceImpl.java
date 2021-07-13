package com.avdbearing.services;

import com.avdbearing.domain.core.Part;
import com.avdbearing.dto.PartCreateDto;
import com.avdbearing.repositories.*;

import javax.annotation.Resource;
import java.util.List;


public class PartsServiceImpl implements PartService {
    @Resource
    private PartRepository partRepository;


    @Override
    public List<Part> getAll() {
        return null;
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
