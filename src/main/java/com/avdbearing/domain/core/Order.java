package com.avdbearing.domain.core;


import com.avdbearing.domain.Client;
import com.avdbearing.domain.Enum.OrderStatus;
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

public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    @OneToOne
    private Client client;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @OneToMany
    private List<Payment> payments = new ArrayList<>();


    @ElementCollection
    @CollectionTable(name = "part_amount")
    @Column(name = "amount")
    private Map<Part, Integer> parts = new HashMap<>();

    private LocalDateTime sold;


}
