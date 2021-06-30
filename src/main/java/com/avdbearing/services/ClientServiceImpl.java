package com.avdbearing.services;

import com.avdbearing.domain.Client;
import com.avdbearing.domain.Contact;
import com.avdbearing.domain.User;
import com.avdbearing.repositories.ContactRepository;
import com.avdbearing.repositories.UserRepository;

import javax.annotation.Resource;
import java.util.List;

public class ClientServiceImpl implements ClientService{
    @Override
    public List<Client> getAll() {
        return null;
    }

    @Resource
    private UserRepository userRepository;
    @Resource
    private ContactRepository contactRepository;

    @Override
    public void addClient(Client client, Contact contact, User user, User manager) {

    }

    @Override
    public void updateClient(Client client, Contact contact, User user, User manager) {

    }

    @Override
    public void deleteClient(Client second_name, Client first_name, User manager) {

    }
}
