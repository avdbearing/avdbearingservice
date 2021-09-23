package com.avdbearing.repositories;

import com.avdbearing.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findClientByContact_Phone(String phone);

}
