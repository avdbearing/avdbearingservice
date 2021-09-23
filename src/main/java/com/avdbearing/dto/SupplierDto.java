package com.avdbearing.dto;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SupplierDto {
    private long id;
    private ContactDto contact;
    private String companyName;
    private String site;
    private boolean isForeign;



}
