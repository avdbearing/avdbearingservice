package com.avdbearing.services;

import com.avdbearing.domain.core.Part;
import com.avdbearing.dto.PartDto;


import java.util.List;


public interface PartService {

    void addPart(PartDto partDto);

    void checkInventory(Part article);

    void updatePart(PartDto partDto);

    void deletePart(String article);

    List<Part> getAll();

}
