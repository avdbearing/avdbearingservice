package com.avdbearing.services;

import com.avdbearing.domain.Client;
import com.avdbearing.domain.Contact;
import com.avdbearing.dto.ClientCreateDto;
import com.avdbearing.dto.ClientDto;
import org.springframework.data.domain.Page;


import java.util.List;

public interface ClientService {

    ClientDto addClient(ClientCreateDto clientCreateDto);

    void checkClient(Client client);

    ClientDto getClientById(long id);

    void updateClient(ClientDto clientDto);

    void deleteClientById(long id);

    List<ClientDto> getAll();
    void save(Client client);

    long getTotal();

    Page<Client> findPaginated(int pageNumber, int pageSize, String sortField, String sortDirection);
}
