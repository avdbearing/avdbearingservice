package com.avdbearing.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class AddressDto {

    private long id;
    private String country;
    private String city;
    private String street;
    private int houseNumber;

}
