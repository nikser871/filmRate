package com.example.filmorate.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;


@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private int id;
    private String name;
    private String login;
    private LocalDate birthday;
    private String email;
}
