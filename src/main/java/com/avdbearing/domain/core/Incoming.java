package com.avdbearing.domain.core;


import com.avdbearing.domain.Contact;
import com.avdbearing.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Incoming {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    @OneToOne
    private Supplier supplier;

    @Column(nullable = false)
    private int invoiceNumber;

    @Column(nullable = false)
    private double incomeInvoicePayment;

    @Column(nullable = false)
    private double delivery;
    // надо что бы доставку добавлялу в сумму прихода и делило на все запчасти в процентах

    @OneToOne
    private User user;


    @ElementCollection
    @CollectionTable(name = "part_amount")
    @Column(name = "amount")
    private Map<Part, Integer> newParts = new HashMap<>();

    @ElementCollection
    @CollectionTable(name = "part_amount")
    @Column(name = "amount")
    private Map<Part, Integer> parts = new HashMap<>();
    // надо что бы подтягивало остаток по складу

    private LocalDateTime income;


}
