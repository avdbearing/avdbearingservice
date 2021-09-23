package com.avdbearing.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserCreateDto {
//    private String firstName;
//    private String secondName;
//    private String phone;
//    private String type;
//    private String country;
//    private String city;
//    private String street;
//    private int houseNumber;

    private String email;
    private String password;
    private String userRole;
    private String userStatus;

}
