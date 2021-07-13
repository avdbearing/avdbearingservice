package com.avdbearing.dto;

import com.avdbearing.domain.Enum.PartType;
import lombok.Data;

@Data

public class PartCreateDto {

    private String article;
    private String brand;
    private String type;
    private double inner;
    private double outer;
    private double width;
    private double price;
    private String description;
    private String supplierName;




//    public PartDto(String inner, String outer, String width, String article,
//                   String brand, String description, String price, String type,
//                   String companyName) {
//
//        this.size = new SizeDto(Double.parseDouble(inner), Double.parseDouble(outer), Double.parseDouble(width));
//        this.article = article;
//        this.brand = brand;
//        this.description = description;
//        this.price = Double.parseDouble(price);
//        this.type = PartType.valueOf(type);
//        this.supplier = new SupplierDto(companyName);
//    }


}
