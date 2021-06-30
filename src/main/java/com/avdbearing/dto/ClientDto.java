package com.avdbearing.dto;


import lombok.Data;

@Data
public class ClientDto {
    private long id;
    private ContactDto contact;
    private UserDto user;

}
