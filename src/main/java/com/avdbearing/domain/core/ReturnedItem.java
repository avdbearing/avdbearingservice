package com.avdbearing.domain.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ReturnedItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private long orderId;

    @OneToOne
    private Part part;
    @Column(nullable = false)
    private int quantity;
    @Column(nullable = false)
    private double pricePerUnit;
}
