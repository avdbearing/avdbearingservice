package com.avdbearing.services;

import com.avdbearing.domain.core.Part;
import com.avdbearing.dto.PartCreateDto;
import com.avdbearing.dto.PartDto;


import java.util.List;


public interface PartService {

    void addPart(PartCreateDto partCreateDto);

    void checkInventory(Part article);

    void updatePart(PartCreateDto partCreateDto);

    void deletePart(String article);

    List<PartDto> getAll();

}
