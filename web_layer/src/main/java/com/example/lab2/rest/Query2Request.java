package com.example.lab2.rest;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Query2Request {

    @NotBlank
    private String carBrand;
}
