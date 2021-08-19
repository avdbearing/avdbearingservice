package com.avdbearing.mappers;

import com.avdbearing.domain.Address;
import com.avdbearing.domain.Client;
import com.avdbearing.domain.Contact;
import com.avdbearing.domain.Enum.PartType;
import com.avdbearing.domain.User;
import com.avdbearing.domain.core.Part;
import com.avdbearing.domain.core.Size;
import com.avdbearing.domain.core.Supplier;
import com.avdbearing.dto.*;
import com.avdbearing.repositories.SupplierRepository;


import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


public class BusinessMapper {
    @Resource
    SupplierRepository supplierRepository;


    public Size convertToSize(SizeDto sizeDto) {
        Size size = new Size();
        size.setId(sizeDto.getId());
        size.setInner(sizeDto.getInner());
        size.setOuter(sizeDto.getOuter());
        size.setWidth(sizeDto.getWidth());

        return size;
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
        user.setContact(convertToContact(userDto.getContact()));
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
        SizeDto sizeDto = new SizeDto();
        sizeDto.setId(size.getId());
        sizeDto.setInner(size.getInner());
        sizeDto.setOuter(size.getOuter());
        sizeDto.setWidth(size.getWidth());
        return sizeDto;

    }

    public PartDto convertToPartDto(Part part) {



        PartDto partDto = new PartDto();
        partDto.setId(part.getId());
        partDto.setSizeDto(convertToSizeDto(part.getSize()));
        partDto.setArticle(part.getArticle());
        partDto.setBrand(part.getBrand());
        partDto.setAmount(part.getAmount());
        partDto.setDescription(part.getDescription());
        partDto.setPrice(part.getPrice());
        partDto.setType(part.getType().toString());
        partDto.setSupplier(part.getSupplier().getCompanyName());


        return partDto;


    }

    public Part convertToPart(PartDto partDto) {
        Supplier supplier = supplierRepository.findByCompanyName(partDto.getSupplier());

        Part part = new Part();
        part.setId(partDto.getId());
        part.setSize(convertToSize(partDto.getSizeDto()));
        part.setArticle(partDto.getArticle());
        part.setBrand(partDto.getBrand());
        part.setAmount(partDto.getAmount());
        part.setDescription(partDto.getDescription());
        part.setPrice(partDto.getPrice());
        part.setType(PartType.valueOf(partDto.getType()));
        part.setSupplier(supplier);

        return part;
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

    public AddressDto convertToAddressDto(Address address) {
        AddressDto addressDto = new AddressDto();
        addressDto.setId(address.getId());
        addressDto.setCountry(address.getCountry());
        addressDto.setCity(address.getCity());
        addressDto.setStreet(address.getStreet());
        addressDto.setHouseNumber(address.getHouseNumber());

        return addressDto;
    }

    public ContactDto convertToContactDto(Contact contact) {
        ContactDto contactDto = new ContactDto();

        contactDto.setAddress(convertToAddressDto(contact.getAddress()));
        contactDto.setId(contact.getId());
        contactDto.setFirstName(contact.getFirstName());
        contactDto.setSecondName(contact.getSecondName());
        contactDto.setPhone(contact.getPhone());
        contactDto.setType(contact.getType());
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
        userDto.setContact(convertToContactDto(user.getContact()));
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
