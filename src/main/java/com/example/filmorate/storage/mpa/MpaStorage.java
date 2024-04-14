package com.example.filmorate.storage.mpa;

import com.example.filmorate.model.Genre;
import com.example.filmorate.model.Mpa;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;


public interface MpaStorage {
    Collection<Mpa> getAllMpa();
    Optional<Mpa> getMpaById(int id);
}
