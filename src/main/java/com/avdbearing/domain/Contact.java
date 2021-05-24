package com.avdbearing.domain;


import com.avdbearing.domain.Enum.ContactType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    @Column(nullable = false)
    private String first_name;
    @Column(nullable = false)
    private String second_name;
    @Column(nullable = false, unique = true)
    private String phone;
    @Column(nullable = false)
    private String name_company;
    @Column(nullable = false)
    private String site;

    @OneToOne
    private Address address;

    @Enumerated(EnumType.STRING)
    private ContactType type;

    private LocalDateTime created;
    private LocalDateTime updated;


}

