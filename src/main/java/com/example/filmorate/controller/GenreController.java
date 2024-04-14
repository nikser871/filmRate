package com.example.filmorate.controller;

import com.example.filmorate.model.Genre;
import com.example.filmorate.storage.genre.GenreStorage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(value = "/genres")
public class GenreController {

    private final GenreStorage genreStorage;

    @Autowired
    public GenreController(GenreStorage genreStorage) {
        this.genreStorage = genreStorage;
    }

    @GetMapping
    public Collection<Genre> getAllGenres() {
        return genreStorage.getGenres();
    }


    @GetMapping("/{id}")
    public Optional<Genre> getGenreById(@PathVariable int id) {
        return genreStorage.getGenreById(id);
    }
}
