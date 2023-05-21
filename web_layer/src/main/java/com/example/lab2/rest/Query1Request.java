package com.example.lab2.rest;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Query1Request {

    @NotNull
    @Positive
    private Long instructorId;
}
