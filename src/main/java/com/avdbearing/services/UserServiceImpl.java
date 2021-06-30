package com.avdbearing.services;

import com.avdbearing.domain.Contact;
import com.avdbearing.domain.User;
import com.avdbearing.repositories.ContactRepository;
import com.avdbearing.repositories.UserRepository;

import javax.annotation.Resource;
import java.util.List;

public class UserServiceImpl implements UserService {
    @Resource
    private UserRepository userRepository;
    @Resource
    private ContactRepository contactRepository;

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public void addUser(User user, Contact contact, User manager) {

    }

    @Override
    public void updateUser(User user, Contact contact, User manager) {

    }

    @Override
    public void deleteUser(User email, User manager) {

    }
}
