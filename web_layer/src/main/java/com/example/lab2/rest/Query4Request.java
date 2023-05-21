package com.example.lab2.rest;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Query4Request {

    @NotNull
    @PositiveOrZero
    private Integer studentsQuantity;
}
