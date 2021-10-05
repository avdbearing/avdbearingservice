package com.avdbearing;

import com.avdbearing.domain.Address;
import com.avdbearing.domain.Contact;
import com.avdbearing.domain.Enum.ContactType;
import com.avdbearing.domain.Enum.PartType;
import com.avdbearing.domain.core.Part;
import com.avdbearing.domain.core.Size;
import com.avdbearing.domain.core.Supplier;
import com.avdbearing.dto.ClientCreateDto;
import com.avdbearing.dto.UserCreateDto;
import com.avdbearing.dto.UserDto;
import com.avdbearing.repositories.*;
import com.avdbearing.services.ClientService;
import com.avdbearing.services.UserService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@SpringBootApplication
public class AvdbearingApplication {

    public static void main(String[] args) {
        SpringApplication.run(AvdbearingApplication.class, args);
    }

}


@Component
class AppStartupRunner implements ApplicationRunner {
    @Resource
    PartRepository partRepository;
    @Resource
    AddressRepository addressRepository;
    @Resource
    SizeRepository sizeRepository;
    @Resource
    ContactRepository contactRepository;
    @Resource
    SupplierRepository supplierRepository;
    @Resource
    UserService userService;
    @Resource
    ClientService clientService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Size firstSize = new Size(1, 22, 33, 44);
        sizeRepository.save(firstSize);
        Address address = new Address(1, "poland", "krakov", "krakovska", 4,
                LocalDateTime.now(), LocalDateTime.now());
        addressRepository.save(address);

        Contact contact = new Contact(1, "kirill", "nakazny", "+380674445533",
                address, ContactType.SUPPLIER, LocalDateTime.now(), LocalDateTime.now());
        contactRepository.save(contact);

        Supplier supplier = new Supplier(1, contact, "motogama", "moto.com",
                true, LocalDateTime.now(), LocalDateTime.now());
        supplierRepository.save(supplier);

        Part firstPart = new Part(1, firstSize, "6203", "SNR", 2, "bearing",
                23, PartType.BEARING, supplier, true, LocalDateTime.now(), LocalDateTime.now());

        partRepository.save(firstPart);

//        userService.addUser(new UserCreateDto("client@gmail.com", "qwerty", "CLIENT", "NEW"));

        clientService.addClient(new ClientCreateDto("serg", "serg", "+32423423423", "CLIENT", "ukraine", "kiev",
                "kievska", 5, "serg@", "qwerty", "CLIENT", "NEW"));

    }


}