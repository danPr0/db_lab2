package com.example.lab2.entity;

import lombok.*;

import java.time.Year;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Car {

    private Long id;
    private String brand;
    private String model;
    private Year year;
    private Long categoryId;
}
