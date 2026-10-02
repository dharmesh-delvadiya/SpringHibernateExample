package com.demo.service;

import com.demo.entities.User;

import java.util.List;

public interface UserService {
    User getUser(Integer userId);

    List<User> getUsers();

    User addUser(User user);

    User removeUser(Integer user);

//    Boolean isUserExist(Integer user);
}
