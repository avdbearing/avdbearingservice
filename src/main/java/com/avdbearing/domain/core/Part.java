package com.avdbearing.domain.core;

import com.avdbearing.domain.Enum.PartType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity


public class Part {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    @OneToOne
    private Size size;
    @Column(nullable = false)
    private String article;
    @Column(nullable = false)
    private String brand;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private double price;
    @Enumerated(EnumType.STRING)
    private PartType type;
    @OneToOne
    private Supplier supplier;


    private LocalDateTime created;
    private LocalDateTime updated;


}
