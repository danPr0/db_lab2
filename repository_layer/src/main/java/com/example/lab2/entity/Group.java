package com.example.lab2.entity;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Group {

    @Positive
    @NotNull
    private Long id;

    private LocalDate startDate;

    @PositiveOrZero
    private Integer lecturesCovered;

    @Pattern(regexp = "[ABCD]")
    @NotNull
    private String categoryId;

    @Positive
    private Long teacherId;
}
