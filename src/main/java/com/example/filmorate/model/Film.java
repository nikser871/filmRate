package com.example.filmorate.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Data
@RequiredArgsConstructor
public class Film {
    private int id;
    @NotNull(message = "Name is null")
    @NotBlank(message = "Name is null")
    private String name;
    private String description;
    private LocalDate releaseDate;
    private int duration;
    private Set<Long> followers = new HashSet<>();

}
