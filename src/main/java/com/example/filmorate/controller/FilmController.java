package com.example.filmorate.controller;


import com.example.filmorate.exception.FilmException;
import com.example.filmorate.exception.UserException;
import com.example.filmorate.model.Film;
import com.example.filmorate.validation.FilmValidation;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@Slf4j
@RestController
@RequestMapping(value = "/films")
public class FilmController {
    Map<Integer, Film> films = new HashMap<>();


    @PostMapping
    public Film createFilm(@Valid @RequestBody Film film) throws FilmException {

        FilmValidation.checkName(film.getName());
        FilmValidation.checkDescription(film.getDescription());
        FilmValidation.checkDataRelease(film.getReleaseDate());
        FilmValidation.checkDuration(film.getDuration());

        log.info("Object: {}", film);

        films.put(film.getId(), film);
        return film;
    }


    @PutMapping
    public Film updateFilm(@Valid @RequestBody Film film) throws FilmException {

        FilmValidation.checkName(film.getName());
        FilmValidation.checkDescription(film.getDescription());
        FilmValidation.checkDataRelease(film.getReleaseDate());
        FilmValidation.checkDuration(film.getDuration());

        log.info("Object: {}", film);
        films.put(film.getId(), film);
        return film;
    }

    @GetMapping
    public Map<Integer, Film> getAllFilms() {
        return films;
    }
}
