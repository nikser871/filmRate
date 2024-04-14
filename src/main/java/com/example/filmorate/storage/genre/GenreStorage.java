package com.example.filmorate.storage.genre;

import com.example.filmorate.model.Genre;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;


public interface GenreStorage {
    Collection<Genre> getGenres();
    Optional<Genre> getGenreById(int id);
}
