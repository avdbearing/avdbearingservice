package com.avdbearing.domain.core;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    @ElementCollection
    @CollectionTable(name = "part_amount")
    @Column(name = "amount")
    private Map<Part, Integer> parts = new HashMap<>();


}
