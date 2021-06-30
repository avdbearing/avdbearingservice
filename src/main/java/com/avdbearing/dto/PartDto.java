package com.avdbearing.dto;

import com.avdbearing.domain.Enum.PartType;
import lombok.Data;

@Data

public class PartDto {

    private long id;
    private SizeDto size;
    private String article;
    private String brand;
    private String description;
    private double price;
    private PartType type;
    private SupplierDto supplier;
}
