package com.example.filmorate.storage.user;

import com.example.filmorate.model.User;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public interface UserStorage {
    User createUser(User user);
    User updateUser(User user);
    Map<Integer, User> getAllUsers();

}
