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

    private long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String secondName;
    @Column(nullable = false, unique = true)
    private String phone;

    @OneToOne
    private Address address;

    @Enumerated(EnumType.STRING)
    private ContactType type;

    private LocalDateTime created;
    private LocalDateTime updated;


}

