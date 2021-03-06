package com.avdbearing.services;

import com.avdbearing.domain.Client;
import com.avdbearing.domain.core.Supplier;
import com.avdbearing.dto.ClientCreateDto;
import com.avdbearing.dto.ClientDto;
import com.avdbearing.mappers.BusinessMapper;
import com.avdbearing.repositories.AddressRepository;
import com.avdbearing.repositories.ClientRepository;
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
public class ClientServiceImpl implements ClientService {
    @Resource
    private BusinessMapper businessMapper;
    @Resource
    private AddressRepository addressRepository;
    @Resource
    private ClientRepository clientRepository;
    @Resource
    private UserRepository userRepository;
    @Resource
    private ContactRepository contactRepository;


    @Override
    public ClientDto addClient(ClientCreateDto clientCreateDto) {

        Client client = businessMapper.convertToClientEntity(clientCreateDto);


        addressRepository.save(client.getContact().getAddress());
        contactRepository.save(client.getContact());
        userRepository.save(client.getUser());


        clientRepository.save(client);


        return businessMapper.convertToClientDto(client);
    }

    @Override
    public void checkClient(Client client) {

    }

    @Override
    public ClientDto getClientById(long id) {
        Client currentClient = clientRepository.findById(id).orElseThrow();

        System.out.println(currentClient);


        return businessMapper.convertToClientDto(currentClient);
    }

    @Override
    public void updateClient(ClientDto clientDto) {
        System.out.println("->"+clientDto);

        Client entityClient = businessMapper.convertToClient(clientDto);

        System.out.println("->"+entityClient);
        addressRepository.save(entityClient.getContact().getAddress());
        contactRepository.save(entityClient.getContact());
        userRepository.save(entityClient.getUser());
        clientRepository.save(entityClient);

    }

    @Override
    public void deleteClientById(long id) {
        clientRepository.deleteById(id);

    }

    @Override
    public List<ClientDto> getAll() {
        List<Client> clients = clientRepository.findAll();
        return businessMapper.convertToClientListDto(clients);
    }
    @Override
    public void save(Client client) {
        clientRepository.save(client);
    }

    @Override
    public long getTotal() {

        return clientRepository.count();
    }

    @Override
    public Page<Client> findPaginated(int pageNumber, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortField).ascending() : Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, sort);
        return clientRepository.findAll(pageable);
    }

}
