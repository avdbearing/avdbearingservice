package com.avdbearing.dto;

import com.avdbearing.domain.Enum.ContactType;
import lombok.Data;

@Data
public class ContactCreateDto {

    private String firstName;
    private String secondName;
    private String phone;
    private String type;
    private String country;
    private String city;
    private String street;
    private int houseNumber;

}
