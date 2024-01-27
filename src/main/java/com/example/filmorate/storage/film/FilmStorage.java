package com.example.filmorate.storage.film;

import com.example.filmorate.model.Film;

import java.util.Map;

public interface FilmStorage {
    Film createFilm(Film film);
    Film updateFilm(Film film);
    Map<Integer, Film> getAllFilms();

}
