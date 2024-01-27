package com.example.filmorate.controller;

import com.example.filmorate.exception.UserException;
import com.example.filmorate.model.Film;
import com.example.filmorate.model.User;
import com.example.filmorate.service.FilmService;
import com.example.filmorate.service.UserService;
import com.example.filmorate.storage.film.FilmStorage;
import com.example.filmorate.storage.film.InMemoryFilmStorage;
import com.example.filmorate.storage.user.InMemoryUserStorage;
import com.example.filmorate.storage.user.UserStorage;
import com.example.filmorate.validation.UserValidation;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserStorage userStorage;
    private final UserService service;

    @Autowired
    public UserController(InMemoryUserStorage userStorage, UserService service) {
        this.userStorage = userStorage;
        this.service = service;
    }

    @PostMapping
    public User createUser(@Valid @RequestBody User user) {
        return userStorage.createUser(user);

    }

    @PutMapping
    public User updateUser(@Valid @RequestBody User user) {
        return userStorage.updateUser(user);

    }

    @GetMapping
    public Map<Integer, User> getAllUsers() {
        return userStorage.getAllUsers();
    }

    @PutMapping(value = "{id}/friends/{friendId}")
    public String addFriend(@PathVariable int id, @PathVariable int friendId){
        return service.addFriend(id, friendId);
    }

    @DeleteMapping(value = "{id}/friends/{friendId}")
    public String deleteFriend(@PathVariable int id, @PathVariable int friendId){
        return service.deleteFriend(id, friendId);
    }

    @GetMapping(value = "{id}/friends")
    public List<User> getListOfFriends(@PathVariable int id){
        return service.getFriends(id);
    }

    @GetMapping(value = "{id}/friends/common/{otherId}")
    public List<User> getCommonFriends(@PathVariable int id, @PathVariable int otherId){
        return service.getCommonFriends(id, otherId);
    }
}
