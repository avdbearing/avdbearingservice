package com.avdbearing.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
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
