package com.avdbearing.services;

import com.avdbearing.domain.core.Part;
import com.avdbearing.dto.PartCreateDto;
import com.avdbearing.dto.PartDto;


import java.util.List;


public interface PartService {

    PartDto addPart(PartCreateDto partCreateDto);

    void checkInventory(Part article);

    PartDto getPartById(long id);

    void updatePart(PartDto partDto);


    void deletePartById(long id);

    List<PartDto> getAll();

}
