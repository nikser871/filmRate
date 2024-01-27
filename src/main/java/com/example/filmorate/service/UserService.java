package com.example.filmorate.service;

import com.example.filmorate.model.User;
import com.example.filmorate.storage.user.InMemoryUserStorage;
import com.example.filmorate.storage.user.UserStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserStorage userStorage;

    @Autowired
    public UserService(InMemoryUserStorage userStorage) {
        this.userStorage = userStorage;
    }


    public String addFriend(int id1, int id2) {
        userStorage.getAllUsers().get(id1).getFriends().add((long) id2);
        return "Well done!!!";
    }

    public String deleteFriend(int id1, int id2) {
        userStorage.getAllUsers().get(id1).getFriends().remove((long) id2);
        return "Well delete!!!";
    }

    public List<User> getCommonFriends(int id1, int id2) {
        List<Long> ids = userStorage.getAllUsers().get(id1)
                .getFriends()
                .stream()
                .filter(x -> userStorage.getAllUsers().get(id2).getFriends().contains(x)).toList();

        List<User> result = new ArrayList<>();

        for (long a: ids
             ) {
            result.add(userStorage.getAllUsers().get((int) a));
        }

        return result;

    }

    public List<User> getFriends(int userID) {
        Set<Long> idFriends = userStorage.getAllUsers().get(userID).getFriends();
        List<User> result = new ArrayList<>();
        for (long a: idFriends
        ) {
            result.add(userStorage.getAllUsers().get((int) a));
        }
        return result;
    }

}
