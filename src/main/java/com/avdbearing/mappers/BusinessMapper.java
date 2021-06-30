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


    public static Part convertToPart(PartDto partDto) {
        Part part = new Part();
        part.setId(partDto.getId());
        part.setSize(convertToSize(partDto.getSize()));
        part.setArticle(partDto.getArticle());
        part.setBrand(partDto.getBrand());
        part.setDescription(partDto.getDescription());
        part.setPrice(partDto.getPrice());
        part.setType(partDto.getType());
        part.setSupplier(convertToSupplier(partDto.getSupplier()));


        return part;
    }

}
