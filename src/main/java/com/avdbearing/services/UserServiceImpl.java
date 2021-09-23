package com.avdbearing.services;

import com.avdbearing.domain.Contact;
import com.avdbearing.domain.User;
import com.avdbearing.dto.UserCreateDto;
import com.avdbearing.dto.UserDto;
import com.avdbearing.mappers.BusinessMapper;
import com.avdbearing.repositories.AddressRepository;
import com.avdbearing.repositories.ContactRepository;
import com.avdbearing.repositories.UserRepository;

import javax.annotation.Resource;
import java.util.List;

public class UserServiceImpl implements UserService {
    @Resource
    private UserRepository userRepository;
    @Resource
    private ContactRepository contactRepository;
    @Resource
    private AddressRepository addressRepository;
    @Resource
    private BusinessMapper businessMapper;


    @Override
    public UserDto addUser(UserCreateDto userCreateDto) {

        User user = businessMapper.convertToUserEntity(userCreateDto);

//        addressRepository.save(user.getContact().getAddress());
//        contactRepository.save(user.getContact());
        userRepository.save(user);


        return businessMapper.convertToUserDto(user);
    }

    @Override
    public void User(User user) {

    }

    @Override
    public UserDto getUserById(long id) {
        return null;
    }

    @Override
    public void updateUser(UserDto userDto) {

    }

    @Override
    public void deleteUserById(long id) {

    }

    @Override
    public List<UserDto> getAll() {
        List<User> users = userRepository.findAll();
        return businessMapper.convertToUserListDto(users);
    }
}
