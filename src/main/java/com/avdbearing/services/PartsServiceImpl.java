package com.avdbearing.services;

import com.avdbearing.domain.User;
import com.avdbearing.domain.core.Part;
import com.avdbearing.dto.PartDto;
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
    public void addPart(PartDto partDto) {


    }

    @Override
    public void checkInventory(Part article) {

    }

    @Override
    public void updatePart(PartDto partDto) {

    }

    @Override
    public void deletePart(String article) {

    }
}
