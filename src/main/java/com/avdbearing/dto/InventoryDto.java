package com.avdbearing.dto;

import com.avdbearing.domain.core.Part;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class InventoryDto {
    private long id;
    private Map<Part, Integer> parts = new HashMap<>();


}
