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
public class PartDto {
    private long id;
    @NotNull
    @Size(min = 2, max = 100 , message = "error article")
    private String article;

    private String brand;
    private int amount;
    private String type;
    private SizeDto sizeDto;
    @NotNull
    @Size(min = 2, max = 100)
    private String description;
    private double price;
    private String supplier;
}
