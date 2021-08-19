package com.avdbearing.dto;

import lombok.Data;


@Data
public class SupplierDto {
    private long id;
    private ContactDto contact;
    private String companyName;
    private String site;
    private boolean isForeign;


}
