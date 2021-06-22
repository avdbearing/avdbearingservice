package com.avdbearing.domain.core;


import com.avdbearing.domain.Client;
import com.avdbearing.domain.Contact;
import com.avdbearing.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PurchaseReturns {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    @OneToOne
    private Client client;
    @OneToOne
    private User manager;


    @Column(nullable = false)
    private boolean packaged;

    @Column(nullable = false)
    private long orderNumber;


    @OneToMany
    private List<Part> parts = new ArrayList<>();

    private LocalDateTime sold;
    private LocalDateTime returned;

}
