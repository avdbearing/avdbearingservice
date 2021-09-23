package com.avdbearing.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClientDto {
    private long id;
    private ContactDto contact;
    private UserDto user;

}
