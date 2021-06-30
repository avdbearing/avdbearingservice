package com.avdbearing.services;

import com.avdbearing.domain.Client;
import com.avdbearing.domain.Contact;
import com.avdbearing.domain.User;
import com.avdbearing.domain.core.Part;

import java.util.List;

public interface ClientService {

    void addClient(Client client, Contact contact, User user, User manager);

    void updateClient(Client client, Contact contact, User user, User manager);

    void deleteClient(Client second_name, Client first_name, User manager);
    // or email, or id

    List<Client> getAll();


}
