package com.example.filmorate.controller;


import com.example.filmorate.model.Film;
import com.example.filmorate.service.FilmService;
import com.example.filmorate.storage.film.FilmStorage;
import com.example.filmorate.storage.film.InMemoryFilmStorage;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@Slf4j
@RestController
@RequestMapping(value = "/films")
public class FilmController {

    private final FilmStorage filmStorage;
    private final FilmService service;

    @Autowired
    public FilmController(InMemoryFilmStorage filmStorage, FilmService service) {
        this.filmStorage = filmStorage;
        this.service = service;
    }


    @PostMapping
    public Film createFilm(@Valid @RequestBody Film film) {
        return filmStorage.createFilm(film);
    }


    @PutMapping
    public Film updateFilm(@Valid @RequestBody Film film) {
        return filmStorage.updateFilm(film);
    }

    @GetMapping
    public Map<Integer, Film> getAllFilms() {
        return filmStorage.getAllFilms();
    }

    @PutMapping(value = "/{id}/like/{userId}")
    public String likeTheMovie(@PathVariable int id, @PathVariable int userId) {
        return service.addFollower(id, userId);
    }

    @DeleteMapping(value = "/{id}/like/{userId}")
    public String deleteLike(@PathVariable int id, @PathVariable int userId) {
        return service.deleteFollower(id, userId);
    }

    @GetMapping (value = "/popular")
    public List<Film> getPopularFilms(@RequestParam(defaultValue = "10") String count){
        return service.getTopFilms(Integer.parseInt(count));
    }




    // Add Methods!!!!!!!


}
