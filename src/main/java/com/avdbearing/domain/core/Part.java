package com.avdbearing.domain.core;

import com.avdbearing.domain.Enum.PartType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity


public class Part {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    @OneToOne
    private Size size;
    @Column(nullable = false)
    private String article;


//    @OneToOne
//    private Part analogFor;

    @OneToOne
    private Brand brand;

    @Column(nullable = false)
    private int amount;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private double price;
    @Enumerated(EnumType.STRING)
    private PartType type;
    @OneToOne
    private Supplier supplier; //fixme argue!!!
    @Column(nullable = false)
    private boolean isNew;


//    @ElementCollection
//    @CollectionTable(name = "data")
//    @Column(name = "price")
//    private Map<LocalDateTime, Double> costDynamic = new LinkedHashMap<>();


    private LocalDateTime created;
    private LocalDateTime updated;


}
