package com.example.lab2.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Teacher {

    private Long id;
    private String email;
    private String phoneNumber;
    private String firstName;
    private String secondName;
}
