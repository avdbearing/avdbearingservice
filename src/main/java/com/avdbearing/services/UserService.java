package com.avdbearing.services;

import com.avdbearing.domain.Contact;
import com.avdbearing.domain.User;

import java.util.List;


public interface UserService {


    void addUser(User user, Contact contact, User manager);

    void updateUser(User user, Contact contact, User manager);

    void deleteUser(User email, User manager);

    List<User> getAll();
}
