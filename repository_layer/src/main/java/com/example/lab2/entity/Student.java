package com.example.lab2.entity;

import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Student {

    @Positive
    @NotNull
    private Long id;

    @Email
    @NotNull
    private String email;

    @Pattern(regexp = "0[0-9]{9}")
    @NotNull
    private String phoneNumber;

    @NotBlank
    private String firstName;

    @NotBlank
    private String secondName;

    @PositiveOrZero
    private Integer practiceCount;

    @Positive
    private Long groupId;

    @Positive
    private Long instructorId;
}
