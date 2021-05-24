package com.avdbearing.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PaymentInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    @OneToOne
    private Contact contact;

    private String iban;
    @Column(nullable = false)
    private int mfo;
    @Column(nullable = false)
    private String card_number;
    @Column(nullable = false)
    private String edrnoy;
    @Column(nullable = false)
    private String bank_name;

    private LocalDateTime created;
    private LocalDateTime updated;

}
