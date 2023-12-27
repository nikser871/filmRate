package com.example.filmorate.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class User {
    private int id;
    @Email
    private String email;
    @NotNull(message = "Login is null")
    @NotBlank(message = "Login is null")
    private String login;
    private String name;
    private LocalDate birthday;
}
