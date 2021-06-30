package com.avdbearing.domain.core;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "sizes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    @Column(name = "innerSize")
    private double inner;
    @Column(name = "outerSize")
    private double outer;
    private double width;


}
