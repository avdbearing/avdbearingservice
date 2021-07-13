package com.avdbearing.dto;

import lombok.Data;

@Data
public class SizeDto {
    private long    id;
    private double inner;
    private double outer;
    private double width;

//    public SizeDto( double inner, double outer, double width) {
//        this.inner = inner;
//        this.outer = outer;
//        this.width = width;
//    }
}
