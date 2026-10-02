package com.demo.dao;

import com.demo.entities.User;

import java.util.List;

public interface UserDao  {
    User getUser(Integer userId);

    List<User> getUsers();

    User addUser(User user);

    User removeUser(Integer userId);

//    Boolean isUserExist(User user);
}
