package com.avdbearing.mappers;

import com.avdbearing.domain.Address;
import com.avdbearing.domain.Client;
import com.avdbearing.domain.Contact;
import com.avdbearing.domain.User;
import com.avdbearing.domain.core.Part;
import com.avdbearing.domain.core.Size;
import com.avdbearing.domain.core.Supplier;
import com.avdbearing.dto.*;

public class BusinessMapper {

    public static Size convertToSize(SizeDto sizeDto) {
        Size size = new Size();
        size.setId(sizeDto.getId());
        size.setInner(sizeDto.getInner());
        size.setOuter(sizeDto.getOuter());
        size.setWidth(sizeDto.getWidth());

        return size;
    }

    public static Address convertToAddress(AddressDto addressDto) {
        Address address = new Address();
        address.setId(addressDto.getId());
        address.setCountry(addressDto.getCountry());
        address.setCity(addressDto.getCity());
        address.setStreet(addressDto.getStreet());
        address.setHouseNumber(addressDto.getHouseNumber());
        return address;
    }

    public static Contact convertToContact(ContactDto contactDto) {
        Contact contact = new Contact();
        contact.setAddress(convertToAddress(contactDto.getAddress()));
        contact.setId(contactDto.getId());
        contact.setFirstName(contactDto.getFirstName());
        contact.setSecondName(contactDto.getSecondName());
        contact.setPhone(contactDto.getPhone());
        contact.setType(contactDto.getType());
        return contact;
    }

    public static Supplier convertToSupplier(SupplierDto supplierDto) {
        Supplier supplier = new Supplier();
        supplier.setId(supplierDto.getId());
        supplier.setContact(convertToContact(supplierDto.getContact()));
        supplier.setCompanyName(supplierDto.getCompanyName());
        supplier.setSite(supplierDto.getSite());
        supplier.setForeign(supplierDto.isForeign());

        return supplier;
    }

    public static User convertToUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setContact(convertToContact(userDto.getContact()));
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setUserRole(userDto.getUserRole());
        user.setUserStatus(userDto.getUserStatus());
        return user;
    }

    public static Client convertToClient(ClientDto clientDto) {
        Client client = new Client();
        client.setId(clientDto.getId());
        client.setContact(convertToContact(clientDto.getContact()));
        client.setUser(convertToUser(clientDto.getUser()));

        return client;
    }


//

    public static SizeDto convertToSizeDto(Size size) {
        SizeDto sizeDto = new SizeDto();
        sizeDto.setId(size.getId());
        sizeDto.setInner(size.getInner());
        sizeDto.setOuter(size.getOuter());
        sizeDto.setWidth(size.getWidth());
        return sizeDto;

    }

//    public static PartCreateDto convertToPartDto(Part part) {
//        PartCreateDto partCreateDto = new PartCreateDto();
//        partCreateDto.setId(part.getId());
//        partCreateDto.setSize(convertToSizeDto(part.getSize()));
//        partCreateDto.setArticle(part.getArticle());
//        partCreateDto.setBrand(part.getBrand());
//        partCreateDto.setDescription(part.getDescription());
//        partCreateDto.setPrice(part.getPrice());
//        partCreateDto.setType(part.getType());
//        partCreateDto.setSupplier(convertToSupplierDto(part.getSupplier()));
//
//
//        return partCreateDto;
//
//
//    }

    public static AddressDto convertToAddressDto(Address address) {
        AddressDto addressDto = new AddressDto();
        addressDto.setId(address.getId());
        addressDto.setCountry(address.getCountry());
        addressDto.setCity(address.getCity());
        addressDto.setStreet(address.getStreet());
        addressDto.setHouseNumber(address.getHouseNumber());

        return addressDto;
    }

    public static ContactDto convertToContactDto(Contact contact) {
        ContactDto contactDto = new ContactDto();

        contactDto.setAddress(convertToAddressDto(contact.getAddress()));
        contactDto.setId(contact.getId());
        contactDto.setFirstName(contact.getFirstName());
        contactDto.setSecondName(contact.getSecondName());
        contactDto.setPhone(contact.getPhone());
        contactDto.setType(contact.getType());
        return contactDto;

    }

    public static SupplierDto convertToSupplierDto(Supplier supplier) {
        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setId(supplier.getId());
        supplierDto.setContact(convertToContactDto(supplier.getContact()));
        supplierDto.setCompanyName(supplier.getCompanyName());
        supplierDto.setSite(supplier.getSite());
        supplierDto.setForeign(supplier.isForeign());

        return supplierDto;

    }

    public static UserDto convertToUserDto(User user) {

        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setContact(convertToContactDto(user.getContact()));
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setUserRole(user.getUserRole());
        userDto.setUserStatus(user.getUserStatus());

        return userDto;


    }

    public static ClientDto convertToClientDto(Client client) {
        ClientDto clientDto = new ClientDto();

        clientDto.setId(client.getId());
        clientDto.setContact(convertToContactDto(client.getContact()));
        clientDto.setUser(convertToUserDto(client.getUser()));


        return clientDto;
    }


}
