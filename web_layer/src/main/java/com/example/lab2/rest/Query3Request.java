package com.example.lab2.rest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class Query3Request {

    @NotBlank
    @Length(min = 1, max = 1)
    private String categoryId;
}
