package com.demo.service.impl;

import com.demo.dao.UserDao;
import com.demo.entities.User;
import com.demo.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    @Transactional
    public User getUser(Integer userId) {
        System.out.println("SERVICE Layer :: getUser() :: userID :: " + userId);
        return userDao.getUser(userId);
    }

    @Override
    @Transactional
    public List<User> getUsers() {
        System.out.println("SERVICE Layer :: getUsers()");
        return userDao.getUsers();
    }

    @Override
    @Transactional
    public User addUser(User user) {
        System.out.println("SERVICE Layer :: addUser()");
        return userDao.addUser(user);
    }

    @Override
    @Transactional
    public User removeUser(Integer userId) {
        System.out.println("SERVICE Layer :: removeUser()");
        return userDao.removeUser(userId);
    }

//    @Override
//    @Transactional
//    public Boolean isUserExist(User user) {
//        return userDao.isUserExist(user);
//    }
}
