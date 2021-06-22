package com.avdbearing.domain;

import com.avdbearing.domain.core.LineItem;
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
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    @OneToMany
    private List<LineItem> parts = new ArrayList<>();

    private LocalDateTime created;

}
