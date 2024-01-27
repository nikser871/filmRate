package com.example.filmorate.service;

import com.example.filmorate.model.Film;
import com.example.filmorate.storage.film.FilmStorage;
import com.example.filmorate.storage.film.InMemoryFilmStorage;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FilmService {

    private final FilmStorage filmStorage;

    @Autowired
    public FilmService(InMemoryFilmStorage userStorage) {
        this.filmStorage = userStorage;
    }

    public String addFollower(int filmId, long userId) {
        filmStorage.getAllFilms().get(filmId).getFollowers().add(userId);
        return "Все прошло отлично!!!";
    }

    public String deleteFollower(int filmId, int userId) {
        filmStorage.getAllFilms().get(filmId).getFollowers().remove((long) userId);
        return "Film has removed from list!!!";
    }

    public List<Film> getTopFilms(int count) {
        return filmStorage.getAllFilms()
                .values()
                .stream()
                .sorted(Comparator.comparingInt(x -> -x.getFollowers().size()))
                .limit(count)
                .toList();
    }


}
