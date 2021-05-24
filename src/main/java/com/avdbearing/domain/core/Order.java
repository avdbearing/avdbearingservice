package com.avdbearing.domain.core;


import com.avdbearing.domain.Address;
import com.avdbearing.domain.Client;
import com.avdbearing.domain.Enum.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    @Column(nullable = false)
    private int amount;

    @OneToMany
    private List<LineItem> lineItemList;
    @OneToOne
    private Client client;
    @OneToOne
    private Address address;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    private LocalDateTime ordered;
    private LocalDateTime shipped;
}
