package com.example.filmorate.controller;

import com.example.filmorate.exception.UserException;
import com.example.filmorate.model.Film;
import com.example.filmorate.model.User;
import com.example.filmorate.validation.UserValidation;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping(value = "/users")
public class UserController {

    Map<Integer, User> users = new HashMap<>();

    @PostMapping
    public User createUser(@Valid @RequestBody User user) throws UserException {

        UserValidation.checkEmail(user.getEmail());
        UserValidation.checkLogin(user.getLogin());
        UserValidation.checkBirthday(user.getBirthday());

        UserValidation.checkName(user);

        log.info("Object: {}", user);

        users.put(user.getId(), user);
        return user;
    }

    @PutMapping
    public User updateUser(@Valid @RequestBody User user) throws UserException {

        UserValidation.checkEmail(user.getEmail());
        UserValidation.checkLogin(user.getLogin());
        UserValidation.checkBirthday(user.getBirthday());
        UserValidation.checkName(user);

        log.info("Object: {}", user);

        users.put(user.getId(), user);
        return user;
    }

    @GetMapping
    public Map<Integer, User> getAllUsers() {
        return users;
    }


}
