package com.avdbearing.dto;

import com.avdbearing.domain.Contact;
import com.avdbearing.domain.Enum.UserRole;
import com.avdbearing.domain.Enum.UserStatus;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDto {
    private long id;

//    private ContactDto contact;
    private String email;
    private String password;
    private UserRole userRole;
    private UserStatus userStatus;

}
