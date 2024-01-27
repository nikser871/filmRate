package com.example.filmorate.storage.user;

import com.example.filmorate.model.User;
import com.example.filmorate.storage.user.UserStorage;
import com.example.filmorate.validation.UserValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class InMemoryUserStorage implements UserStorage {


    private final Map<Integer, User> users = new HashMap<>();

    @Override
    public User createUser(User user) {
        UserValidation.checkEmail(user.getEmail());
        UserValidation.checkLogin(user.getLogin());
        UserValidation.checkBirthday(user.getBirthday());

        UserValidation.checkName(user);

        log.info("Object: {}", user);

        users.put(user.getId(), user);
        return user;
    }

    @Override
    public User updateUser(User user) {
        UserValidation.checkEmail(user.getEmail());
        UserValidation.checkLogin(user.getLogin());
        UserValidation.checkBirthday(user.getBirthday());
        UserValidation.checkName(user);

        log.info("Object: {}", user);

        users.put(user.getId(), user);
        return user;
    }

    @Override
    public Map<Integer, User> getAllUsers() {
        return users;
    }


}
