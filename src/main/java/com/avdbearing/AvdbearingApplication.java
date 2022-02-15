package com.avdbearing;

import com.avdbearing.domain.Address;
import com.avdbearing.domain.Contact;
import com.avdbearing.domain.Enum.ContactType;
import com.avdbearing.domain.Enum.PartType;
import com.avdbearing.domain.Enum.UserRole;
import com.avdbearing.domain.Enum.UserStatus;
import com.avdbearing.domain.User;
import com.avdbearing.domain.core.Brand;
import com.avdbearing.domain.core.Part;
import com.avdbearing.domain.core.Size;
import com.avdbearing.domain.core.Supplier;
import com.avdbearing.dto.ClientCreateDto;
import com.avdbearing.dto.UserCreateDto;
import com.avdbearing.dto.UserDto;
import com.avdbearing.repositories.*;
import com.avdbearing.services.BrandService;
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
    @Resource
    BrandService brandService;
    @Resource
    BrandRepository brandRepository;
    @Resource
    UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Size firstSize = new Size(1, 22, 33, 44);
        sizeRepository.save(firstSize);
        Size secondSize = new Size(2, 11, 1, 22);
        sizeRepository.save(firstSize);
        sizeRepository.save(secondSize);

        Brand brand1 = new Brand(1, "SNR", LocalDateTime.now(), LocalDateTime.now());
        brandRepository.save(brand1);
        Brand brand2 = new Brand(2, "NSK", LocalDateTime.now(), LocalDateTime.now());
        brandRepository.save(brand2);

        Address address = new Address(1, "poland", "krakov", "krakovska", 4,
                LocalDateTime.now(), LocalDateTime.now());
        addressRepository.save(address);
        Address address1 = new Address(2, "ukraine", "lutsk", "lutska", 3,
                LocalDateTime.now(), LocalDateTime.now());
        addressRepository.save(address1);


        Contact contact = new Contact(1, "kirill", "nakazny", "+380674445533",
                address, ContactType.SUPPLIER, LocalDateTime.now(), LocalDateTime.now());
        contactRepository.save(contact);
        Contact contact1 = new Contact(2, "vitalii", "vitalii", "+380634445544",
                address1, ContactType.SUPPLIER, LocalDateTime.now(), LocalDateTime.now());
        contactRepository.save(contact1);

        Supplier supplier = new Supplier(1, contact, "motogama", "moto.com",
                true, LocalDateTime.now(), LocalDateTime.now());
        supplierRepository.save(supplier);
        Supplier supplier1 = new Supplier(2, contact1, "psv", "psv.com",
                true, LocalDateTime.now(), LocalDateTime.now());
        supplierRepository.save(supplier1);

        Part firstPart = new Part(1, firstSize, "6203", brand1, 2, "bearing",
                23, PartType.BEARING, supplier, true, LocalDateTime.now(), LocalDateTime.now());

        partRepository.save(firstPart);

        Part part1 = new Part(2, secondSize, "12017115b", brand2, 4, "oilseal",
                12, PartType.OILSEAL, supplier1, true, LocalDateTime.now(), LocalDateTime.now());

        partRepository.save(part1);



        User user1 = new User(1, "yarik@gmil.com", "qwerty", UserRole.MANAGER, UserStatus.ACTIVE, LocalDateTime.now(), LocalDateTime.now());
        userRepository.save(user1);
        User user2 = new User(2, "lelik@gmail.com", "1234554321", UserRole.ADMIN, UserStatus.ACTIVE, LocalDateTime.now(), LocalDateTime.now());
        userRepository.save(user2);



        clientService.addClient(new ClientCreateDto("serg", "serg", "+32423423423", "CLIENT", "ukraine", "kiev",
                "kievska", 5, "serg@", "qwerty", "CLIENT", "NEW"));
        clientService.addClient(new ClientCreateDto("nik", "nik", "+380675558844", "CLIENT", "ukraine", "kiev",
                "ekskovatorna", 24, "nik@", "sdfd", "CLIENT", "NEW"));

    }


}