package com.avdbearing.dto;

import lombok.Data;

import javax.persistence.Column;
@Data
public class AddressDto {

    private long id;
    private String country;
    private String city;
    private String street;
    private int houseNumber;

}
