package com.avdbearing.mappers;

import com.avdbearing.domain.Address;
import com.avdbearing.domain.Client;
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
import com.avdbearing.dto.*;
import com.avdbearing.repositories.*;


import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class BusinessMapper {
    @Resource
    SupplierRepository supplierRepository;
    @Resource
    PartRepository partRepository;
    @Resource
    SizeRepository sizeRepository;
    @Resource
    ContactRepository contactRepository;
    @Resource
    ClientRepository clientRepository;
    @Resource
    UserRepository userRepository;
    @Resource
    BrandRepository brandRepository;


    public Size convertToSize(SizeDto sizeDto) {
        Size size = new Size();
        size.setId(sizeDto.getId());
        size.setInner(sizeDto.getInner());
        size.setOuter(sizeDto.getOuter());
        size.setWidth(sizeDto.getWidth());

        return size;
    }

    public Brand convertToBrand(BrandDto brandDto) {
        Brand brand = new Brand();
        brand.setId(brandDto.getId());
        brand.setBrandName(brandDto.getBrandName());
        return brand;
    }

    public BrandDto convertToBrandDto(Brand brand) {
        BrandDto brandDto = new BrandDto();
        brandDto.setId(brand.getId());
        brandDto.setBrandName(brand.getBrandName());

        return brandDto;
    }

    public Address convertToAddress(AddressDto addressDto) {
        Address address = new Address();
        address.setId(addressDto.getId());
        address.setCountry(addressDto.getCountry());
        address.setCity(addressDto.getCity());
        address.setStreet(addressDto.getStreet());
        address.setHouseNumber(addressDto.getHouseNumber());
        return address;
    }

    public Contact convertToContact(ContactDto contactDto) {
        Contact contact = new Contact();
        contact.setAddress(convertToAddress(contactDto.getAddress()));
        contact.setId(contactDto.getId());
        contact.setFirstName(contactDto.getFirstName());
        contact.setSecondName(contactDto.getSecondName());
        contact.setPhone(contactDto.getPhone());
        contact.setType(contactDto.getType());
        return contact;
    }

    public Supplier convertToSupplier(SupplierDto supplierDto) {
        Supplier supplier = new Supplier();
        supplier.setId(supplierDto.getId());
        supplier.setContact(convertToContact(supplierDto.getContact()));
        supplier.setCompanyName(supplierDto.getCompanyName());
        supplier.setSite(supplierDto.getSite());
        supplier.setForeign(supplierDto.isForeign());


        return supplier;
    }

    public User convertToUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setUserRole(userDto.getUserRole());
        user.setUserStatus(userDto.getUserStatus());
        return user;
    }

    public Client convertToClient(ClientDto clientDto) {
        Client client = new Client();
        client.setId(clientDto.getId());
        client.setContact(convertToContact(clientDto.getContact()));
        client.setUser(convertToUser(clientDto.getUser()));

        return client;
    }


//

    public SizeDto convertToSizeDto(Size size) {
        SizeDto sizeDto = new SizeDto(size.getId(), size.getInner(), size.getOuter(), size.getWidth());
        sizeDto.setId(size.getId());
//        sizeDto.setInner(size.getInner());
//        sizeDto.setOuter(size.getOuter());
//        sizeDto.setWidth(size.getWidth());
        return sizeDto;

    }

    public PartDto convertToPartDto(Part part) {


        PartDto partDto = new PartDto();
        partDto.setId(part.getId());
        partDto.setSizeDto(convertToSizeDto(part.getSize()));
        partDto.setBrand(part.getBrand().getBrandName());
        partDto.setArticle(part.getArticle());

        partDto.setAmount(part.getAmount());
        partDto.setDescription(part.getDescription());
        partDto.setPrice(part.getPrice());
        partDto.setType(part.getType().toString());
        partDto.setSupplier(part.getSupplier().getCompanyName());


        return partDto;


    }

    public Part convertToPart(PartDto partDto) {
        Supplier supplier = supplierRepository.findByCompanyNameEquals(partDto.getSupplier());
        Brand brand = brandRepository.findBrandByBrandName(partDto.getBrand());
        System.out.println(supplier);


        Part part = new Part();
        part.setId(partDto.getId());
        part.setSize(convertToSize(partDto.getSizeDto()));
        part.setArticle(partDto.getArticle());
        part.setBrand(brand);
        part.setAmount(partDto.getAmount());
        part.setDescription(partDto.getDescription());
        part.setPrice(partDto.getPrice());
        part.setType(PartType.valueOf(partDto.getType()));
        part.setSupplier(supplier);

        return part;
    }

    public PartDto convertToPartDto(PartCreateDto partCreateDto) {

        PartDto partDto = new PartDto();
        SizeDto sizeDto = new SizeDto(0, partCreateDto.getInner(), partCreateDto.getOuter(), partCreateDto.getWidth());
        BrandDto brandDto = new BrandDto(0, partCreateDto.getBrandName());

        partDto.setArticle(partCreateDto.getArticle());
        partDto.setDescription(partCreateDto.getDescription());
        partDto.setAmount(partCreateDto.getAmount());
        partDto.setPrice(partCreateDto.getPrice());
        partDto.setType(partCreateDto.getType());
        partDto.setSizeDto(sizeDto);
        partDto.setSupplier(partCreateDto.getSupplierName());


        return partDto;


    }

    public SupplierDto convertToSupplierDto(SupplierCreateDto supplierCreateDto) {
        SupplierDto supplierDto = new SupplierDto();
        AddressDto addressDto = new AddressDto(0, supplierCreateDto.getCountry(),
                supplierCreateDto.getCity(), supplierCreateDto.getStreet(), 0);
        ContactDto contactDto = new ContactDto(0, supplierCreateDto.getFirstName(),
                supplierCreateDto.getSecondName(), supplierCreateDto.getPhone(), addressDto,
                ContactType.valueOf(supplierCreateDto.getType()));


        supplierDto.setCompanyName(supplierCreateDto.getCompanyName());
        supplierDto.setSite(supplierCreateDto.getSite());
        supplierDto.setContact(contactDto);

        return supplierDto;
    }

    public Part convertToPartEntity(PartCreateDto partCreateDto) {
        Brand brand = brandRepository.findBrandByBrandName(partCreateDto.getBrandName());

        Part findedPart = partRepository.findByBrandAndArticle(brand, partCreateDto.getArticle());
        Supplier supplier = supplierRepository.findByCompanyNameEquals(partCreateDto.getSupplierName());
        Size findedSize = sizeRepository.findByInnerAndOuterAndWidth(partCreateDto.getInner(), partCreateDto.getOuter(), partCreateDto.getWidth());

        if (findedSize == null) {
            findedSize = new Size(0, partCreateDto.getInner(), partCreateDto.getOuter(), partCreateDto.getWidth());
        }

        if (findedPart == null) {
            findedPart = new Part();
        }

        findedPart.setArticle(partCreateDto.getArticle());
        findedPart.setBrand(brand);
        findedPart.setDescription(partCreateDto.getDescription());
        findedPart.setAmount(partCreateDto.getAmount());
        findedPart.setPrice(partCreateDto.getPrice());
        findedPart.setType(PartType.valueOf(partCreateDto.getType()));
        findedPart.setSize(findedSize);
        findedPart.setSupplier(supplier);

        return findedPart;
    }

    public Brand convertToBrandEntity(BrandCreateDto brandCreateDto) {
        Brand findedBrand = brandRepository.findBrandByBrandName(brandCreateDto.getBrandName());
        if (findedBrand == null) {
            findedBrand = new Brand(0, brandCreateDto.getBrandName(), LocalDateTime.now(), LocalDateTime.now());
        }

        return findedBrand;


    }


    public User convertToUserEntity(UserCreateDto userCreateDto) {
        User findedUser = userRepository.findByEmail(userCreateDto.getEmail());
//        Address address = new Address(0, userCreateDto.getCountry(), userCreateDto.getCity(), userCreateDto.getStreet(),
//                userCreateDto.getHouseNumber(), LocalDateTime.now(), LocalDateTime.now());
//        Contact contact = new Contact(0, userCreateDto.getFirstName(), userCreateDto.getSecondName(), userCreateDto.getPhone(),
//                address, ContactType.SUPPLIER, LocalDateTime.now(), LocalDateTime.now());

        if (findedUser == null) {
            findedUser = new User();
            findedUser.setEmail(userCreateDto.getEmail());
            findedUser.setPassword(userCreateDto.getPassword());
            findedUser.setUserStatus(UserStatus.valueOf(userCreateDto.getUserStatus()));
            findedUser.setUserRole(UserRole.valueOf(userCreateDto.getUserRole()));
        }
        return findedUser;
    }

    public Supplier convertToSupplierEntity(SupplierCreateDto supplierCreateDto) {

        Supplier findedSupplier = supplierRepository.findByCompanyNameEquals(supplierCreateDto.getCompanyName());

        Address address = new Address(0, supplierCreateDto.getCountry(), supplierCreateDto.getCity(), supplierCreateDto.getStreet(),
                supplierCreateDto.getHouseNumber(), LocalDateTime.now(), LocalDateTime.now());

        Contact contact = new Contact(0, supplierCreateDto.getFirstName(), supplierCreateDto.getSecondName(), supplierCreateDto.getPhone(),
                address, ContactType.SUPPLIER, LocalDateTime.now(), LocalDateTime.now());


        if (findedSupplier == null) {

            findedSupplier = new Supplier();
            findedSupplier.setCompanyName(supplierCreateDto.getCompanyName());
            findedSupplier.setSite(supplierCreateDto.getSite());
            findedSupplier.setContact(contact);
            findedSupplier.getContact().setAddress(address);

        }


        return findedSupplier;

    }

    public Contact convertToContactEntity(ContactCreateDto contactCreateDto) {


        Contact findedContact = contactRepository.findContactByPhone(contactCreateDto.getPhone());

        Address address = new Address(0, contactCreateDto.getCountry(), contactCreateDto.getCity(), contactCreateDto.getStreet(),
                contactCreateDto.getHouseNumber(), LocalDateTime.now(), LocalDateTime.now());

        if (findedContact == null) {

            findedContact = new Contact();

            findedContact.setFirstName(contactCreateDto.getFirstName());
            findedContact.setSecondName(contactCreateDto.getSecondName());
            findedContact.setPhone(contactCreateDto.getPhone());
            findedContact.setAddress(address);

        }


        return findedContact;

    }

    public Client convertToClientEntity(ClientCreateDto clientCreateDto) {
        Client findedClient = clientRepository.findClientByContact_Phone(clientCreateDto.getPhone());
        Address address = new Address(0, clientCreateDto.getCountry(), clientCreateDto.getCity(), clientCreateDto.getStreet(),
                clientCreateDto.getHouseNumber(), LocalDateTime.now(), LocalDateTime.now());
        Contact contact = new Contact(0, clientCreateDto.getFirstName(), clientCreateDto.getSecondName(), clientCreateDto.getPhone(),
                address, ContactType.CLIENT, LocalDateTime.now(), LocalDateTime.now());
        User user = new User(0, clientCreateDto.getEmail(), clientCreateDto.getPassword(), UserRole.CLIENT, UserStatus.NEW,
                LocalDateTime.now(), LocalDateTime.now());
        if (findedClient == null) {
            findedClient = new Client();


            findedClient.setUser(user);
            findedClient.setContact(contact);
            findedClient.getContact().setAddress(address);


        }
        return findedClient;


    }

    public List<Client> convertToClientList(List<ClientDto> clientDtoList) {
        List<Client> clientList = new ArrayList<>();
        for (int i = 0; i < clientDtoList.size(); i++) {
            clientList.add(convertToClient(clientDtoList.get(i)));
        }

        return clientList;
    }

    public List<ClientDto> convertToClientListDto(List<Client> clients) {
        List<ClientDto> clientDtoList = new ArrayList<>();
        for (int i = 0; i < clients.size(); i++) {
            clientDtoList.add(convertToClientDto(clients.get(i)));
        }
        return clientDtoList;
    }

    public List<User> convertToUserList(List<UserDto> userDtoList) {
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < userDtoList.size(); i++) {
            userList.add(convertToUser(userDtoList.get(i)));
        }
        return userList;
    }

    public List<UserDto> convertToUserListDto(List<User> userList) {
        List<UserDto> userDtoList = new ArrayList<>();
        for (int i = 0; i < userList.size(); i++) {
            userDtoList.add(convertToUserDto(userList.get(i)));
        }
        return userDtoList;
    }


    public List<Part> convertToPartList(List<PartDto> dtoList) {
        List<Part> partList = new ArrayList<>();
//        dtoList.forEach(partDto -> {
//            partList.add(convertToPart(partDto));
//        });

        for (int i = 0; i < dtoList.size(); i++) {
            partList.add(convertToPart(dtoList.get(i)));
        }


//        return dtoList.stream().map(partDto -> convertToPart(partDto)).collect(Collectors.toList());

        return partList;
    }


    public List<PartDto> convertToPartListDto(List<Part> parts) {
        List<PartDto> partDtoList = new ArrayList<>();


        for (int i = 0; i < parts.size(); i++) {

            partDtoList.add(convertToPartDto(parts.get(i)));

        }

        return partDtoList;
    }


    public List<Brand> convertToBrandList(List<BrandDto> brandDtos) {
        List<Brand> brands = new ArrayList<>();
        for (int i = 0; i < brandDtos.size(); i++) {
            brands.add(convertToBrand(brandDtos.get(i)));
        }
        return brands;
    }

    public List<BrandDto> convertToBrandListDto(List<Brand> brands) {
        List<BrandDto> brandDtoList = new ArrayList<>();
        for (int i = 0; i < brands.size(); i++) {
            brandDtoList.add(convertToBrandDto(brands.get(i)));
        }
        return brandDtoList;
    }

    public List<SupplierDto> convertToSupplierListDto(List<Supplier> suppliers) {
        List<SupplierDto> supplierDtoList = new ArrayList<>();
        for (int i = 0; i < suppliers.size(); i++) {

            supplierDtoList.add(convertToSupplierDto(suppliers.get(i)));

        }
        return supplierDtoList;
    }


    public List<Supplier> convertToSupplierList(List<SupplierDto> supplierDtos) {

        List<Supplier> supplierList = new ArrayList<>();
        for (int i = 0; i < supplierDtos.size(); i++) {
            supplierList.add(convertToSupplier(supplierDtos.get(i)));


        }
        return supplierList;
    }


    public List<ContactDto> convertToContactListDto(List<Contact> contacts) {
        List<ContactDto> contactDtoList = new ArrayList<>();
        for (int i = 0; i < contacts.size(); i++) {
            contactDtoList.add(convertToContactDto(contacts.get(i)));
        }
        return contactDtoList;
    }

    public List<Contact> convertToContactList(List<ContactDto> contactDtos) {
        List<Contact> contactList = new ArrayList<>();
        for (int i = 0; i < contactDtos.size(); i++) {
            contactList.add(convertToContact(contactDtos.get(i)));

        }
        return contactList;
    }

    public AddressDto convertToAddressDto(Address address) {
        AddressDto addressDto = new AddressDto(address.getId(), address.getCountry(),
                address.getCity(), address.getStreet(), address.getHouseNumber());
//        addressDto.setId(address.getId());
//        addressDto.setCountry(address.getCountry());
//        addressDto.setCity(address.getCity());
//        addressDto.setStreet(address.getStreet());
//        addressDto.setHouseNumber(address.getHouseNumber());

        return addressDto;
    }

    public ContactDto convertToContactDto(Contact contact) {

        ContactDto contactDto = new ContactDto(
                contact.getId(),
                contact.getFirstName(),
                contact.getSecondName(),
                contact.getPhone(),
                convertToAddressDto(contact.getAddress()),
                contact.getType());


//        contactDto.setAddress(convertToAddressDto(contact.getAddress()));
//        contactDto.setId(contact.getId());
//        contactDto.setFirstName(contact.getFirstName());
//        contactDto.setSecondName(contact.getSecondName());
//        contactDto.setPhone(contact.getPhone());
//        contactDto.setType(contact.getType());
        return contactDto;

    }

    public SupplierDto convertToSupplierDto(Supplier supplier) {
        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setId(supplier.getId());
        supplierDto.setContact(convertToContactDto(supplier.getContact()));
        supplierDto.setCompanyName(supplier.getCompanyName());
        supplierDto.setSite(supplier.getSite());
        supplierDto.setForeign(supplier.isForeign());

        return supplierDto;

    }

    public UserDto convertToUserDto(User user) {

        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setUserRole(user.getUserRole());
        userDto.setUserStatus(user.getUserStatus());

        return userDto;


    }

    public ClientDto convertToClientDto(Client client) {
        ClientDto clientDto = new ClientDto();

        clientDto.setId(client.getId());
        clientDto.setContact(convertToContactDto(client.getContact()));
        clientDto.setUser(convertToUserDto(client.getUser()));


        return clientDto;
    }


}
