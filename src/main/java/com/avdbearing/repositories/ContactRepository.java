package com.avdbearing.repositories;


import com.avdbearing.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    Contact findContactByPhone(String phone);

}
