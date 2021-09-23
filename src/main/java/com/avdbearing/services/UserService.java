package com.avdbearing.services;

import com.avdbearing.domain.Contact;
import com.avdbearing.domain.User;
import com.avdbearing.domain.core.Supplier;
import com.avdbearing.dto.SupplierDto;
import com.avdbearing.dto.UserCreateDto;
import com.avdbearing.dto.UserDto;

import java.util.List;


public interface UserService {


    UserDto addUser(UserCreateDto userCreateDto);

    void User(User user);

    UserDto getUserById(long id);

    void updateUser(UserDto userDto);

    void deleteUserById(long id);

    List<UserDto> getAll();
}
