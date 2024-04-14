package com.example.filmorate.storage.film;

import com.example.filmorate.model.Film;
import com.example.filmorate.model.User;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

public interface FilmStorage {
    Film createFilm(Film film);
    Film updateFilm(Film film);
    Collection<Film> getAllFilms();

    Optional<Integer> getCountOfFollowers(int filmId);

    Optional<Film> getFilmById(int filmId);

}
