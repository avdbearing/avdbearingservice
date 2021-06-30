package com.avdbearing.dto;

import com.avdbearing.domain.Enum.ContactType;
import lombok.Data;

@Data

public class ContactDto {
    private long id;
    private String firstName;
    private String secondName;
    private String phone;
    private AddressDto address;
    private ContactType type;
}
