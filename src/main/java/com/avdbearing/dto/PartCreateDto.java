package com.avdbearing.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PartCreateDto {

    @NotNull
    @Size(min = 2, max = 100)
    private String article;
    private String brand;
    private int amount;
    private String type;
    private double inner;
    private double outer;
    private double width;
    private double price;
    @NotNull
    @Size(min = 2, max = 100)
    private String description;
    private String supplierName;


}
