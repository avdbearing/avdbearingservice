package com.avdbearing.dto;

import lombok.Data;

@Data
public class PartDto {
    private long id;
    private String article;
    private String brand;
    private int amount;
    private String type;
    private SizeDto sizeDto;
    private String description;
    private double price;
    private String supplier;
}
