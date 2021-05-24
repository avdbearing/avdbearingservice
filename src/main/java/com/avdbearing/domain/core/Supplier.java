package com.avdbearing.domain.core;


import com.avdbearing.domain.Contact;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    @OneToOne
    private Contact contact;


    private LocalDateTime created;
    private LocalDateTime updated;


}
