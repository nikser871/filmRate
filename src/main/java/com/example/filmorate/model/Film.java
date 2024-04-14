package com.example.filmorate.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.List;


@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Film {
    @Id
    private int id;
    @NotNull(message = "Name is null")
    @NotBlank(message = "Name is null")
    private String name;
    private String description;
    @NotNull(message = "releaseDate is null")
    private LocalDate releaseDate;
    private int duration;
    private List<Integer> genresId;
    private int mpaId;


}
