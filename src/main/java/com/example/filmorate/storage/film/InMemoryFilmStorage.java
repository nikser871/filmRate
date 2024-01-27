package com.example.filmorate.storage.film;

import com.example.filmorate.model.Film;
import com.example.filmorate.model.User;
import com.example.filmorate.storage.film.FilmStorage;
import com.example.filmorate.validation.FilmValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class InMemoryFilmStorage implements FilmStorage {


    private final Map<Integer, Film> films = new HashMap<>();

    @Override
    public Film createFilm(Film film) {

        FilmValidation.checkName(film.getName());
        FilmValidation.checkDescription(film.getDescription());
        FilmValidation.checkDataRelease(film.getReleaseDate());
        FilmValidation.checkDuration(film.getDuration());

        log.info("Object: {}", film);

        films.put(film.getId(), film);
        return film;
    }

    @Override
    public Film updateFilm(Film film) {
        FilmValidation.checkName(film.getName());
        FilmValidation.checkDescription(film.getDescription());
        FilmValidation.checkDataRelease(film.getReleaseDate());
        FilmValidation.checkDuration(film.getDuration());

        log.info("Object: {}", film);
        films.put(film.getId(), film);
        return film;
    }

    @Override
    public Map<Integer, Film> getAllFilms() {
        return films;
    }
}
