package com.avdbearing.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SupplierCreateDto {

    @NotNull
    @Size(min = 2, max = 100)
    private String companyName;
    @NotNull
    @Size(min = 2, max = 100)
    private String site;
    @NotNull
    @Size(min = 2, max = 100)
    private String firstName;
    @NotNull
    @Size(min = 2, max = 100)
    private String secondName;
    @NotNull
    @Pattern(regexp = "[0-9]{10,13}", message = "wrong phone number format")
    private String phone;
    private String type;
    @NotNull
    @Size(min = 1, max = 40)
    private String country;
    @NotNull
    @Size(min = 1, max = 40)
    private String city;
    @NotNull
    @Size(min = 1, max = 40)
    private String street;

    private int houseNumber;
    private boolean isForeign;
}
