package com.avdbearing.services;

import com.avdbearing.domain.Contact;
import com.avdbearing.domain.core.Supplier;
import com.avdbearing.dto.ContactCreateDto;
import com.avdbearing.dto.ContactDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ContactService {

    ContactDto addContact(ContactCreateDto contactCreateDto);

    void checkContact(Contact contact);

    ContactDto getContactById(long id);

    void updateContact(ContactDto contactDto);

    void deleteContactById(long id);

    List<ContactDto> getAll();
    void save(Contact contact);

    long getTotal();

    Page<Contact> findPaginated(int pageNumber, int pageSize, String sortField, String sortDirection);

}
