package com.avdbearing.dto;

import com.avdbearing.domain.Contact;
import lombok.Data;


@Data
public class SupplierDto {
    private long id;
    private ContactDto contact;
    private String companyName;
    private String site;
    private boolean isForeign;

//    public SupplierDto(String companyName) {
//        this.companyName = companyName;
//    }
}
