package com.avdbearing.domain.core;

import com.avdbearing.domain.Client;
import com.avdbearing.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ReturnToSupplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    @OneToOne
    private User manager;

    @OneToOne
    private Supplier supplier;


    @Column(nullable = false)
    private long orderNumber;


    @OneToMany
    private List<Part> parts = new ArrayList<>();

    private LocalDateTime bought;
    private LocalDateTime returned;
}
