package com.avdbearing.services;

import com.avdbearing.domain.Contact;
import com.avdbearing.domain.User;
import com.avdbearing.domain.core.Supplier;
import com.avdbearing.dto.UserCreateDto;
import com.avdbearing.dto.UserDto;
import com.avdbearing.mappers.BusinessMapper;
import com.avdbearing.repositories.AddressRepository;
import com.avdbearing.repositories.ContactRepository;
import com.avdbearing.repositories.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserRepository userRepository;

    @Resource
    private BusinessMapper businessMapper;


    @Override
    public UserDto addUser(UserCreateDto userCreateDto) {

        User user = businessMapper.convertToUserEntity(userCreateDto);

        userRepository.save(user);


        return businessMapper.convertToUserDto(user);
    }


    @Override
    public UserDto getUserById(long id) {
        User currentUser = userRepository.findById(id).orElseThrow();
        System.out.println(businessMapper.convertToUserDto(currentUser));
        return businessMapper.convertToUserDto(currentUser);
    }

    @Override
    public void updateUser(UserDto userDto) {
        System.out.println(userDto);
        User entityUser = businessMapper.convertToUser(userDto);
        System.out.println(entityUser);
        userRepository.save(entityUser);
    }

    @Override
    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<UserDto> getAll() {
        List<User> users = userRepository.findAll();
        return businessMapper.convertToUserListDto(users);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public long getTotal() {

        return userRepository.count();
    }

    @Override
    public Page<User> findPaginated(int pageNumber, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortField).ascending() : Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, sort);
        return userRepository.findAll(pageable);
    }

}
