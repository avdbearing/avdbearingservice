package com.avdbearing.services;

import com.avdbearing.domain.Contact;
import com.avdbearing.dto.ContactCreateDto;
import com.avdbearing.dto.ContactDto;
import com.avdbearing.mappers.BusinessMapper;
import com.avdbearing.repositories.AddressRepository;
import com.avdbearing.repositories.ContactRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service

public class ContactServiceImpl implements ContactService {
    @Resource
    private BusinessMapper businessMapper;
    @Resource
    private AddressRepository addressRepository;
    @Resource
    private ContactRepository contactRepository;

    public ContactServiceImpl() {
    }


    @Override
    public ContactDto addContact(ContactCreateDto contactCreateDto) {
        Contact contact = businessMapper.convertToContactEntity(contactCreateDto);

        addressRepository.save(contact.getAddress());
        contactRepository.save(contact);


        return businessMapper.convertToContactDto(contact);
    }

    @Override
    public void checkContact(Contact contact) {

    }

    @Override
    public ContactDto getContactById(long id) {
        Contact currentContact = contactRepository.findById(id).orElseThrow();
        System.out.println(businessMapper.convertToContactDto(currentContact));


        return businessMapper.convertToContactDto(currentContact);
    }

    @Override
    public void updateContact(ContactDto contactDto) {
        System.out.println(contactDto);

        Contact entityContact = businessMapper.convertToContact(contactDto);
        System.out.println(entityContact);

        addressRepository.save(entityContact.getAddress());
        contactRepository.save(entityContact);

    }

    @Override
    public void deleteContactById(long id) {
        contactRepository.deleteById(id);
    }

    @Override
    public List<ContactDto> getAll() {
        List<Contact> contacts = contactRepository.findAll();

        return businessMapper.convertToContactListDto(contacts);
    }
}
