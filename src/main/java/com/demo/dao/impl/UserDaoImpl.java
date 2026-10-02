package com.demo.dao.impl;

import com.demo.dao.UserDao;
import com.demo.entities.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    SessionFactory factory;

    @Override
    public User getUser(Integer userId) {
        System.out.println("DAO Layer :: getUser() :: userID :: " + userId);
        return factory.getCurrentSession()
                .createQuery("FROM User user where user.userId = :userId",User.class)
                .setParameter("userId",userId)
                .uniqueResult();
    }

    @Override
    public List<User> getUsers() {
        System.out.println("DAO Layer :: getUsers()");
        return factory.getCurrentSession()
                .createQuery("select user from User user",User.class)
                .list();
    }

    @Override
    public User addUser(User user) {
        System.out.println("DAO Layer :: addUser()");
        factory.getCurrentSession().persist(user);
        return user;
    }

    @Override
    public User removeUser(Integer userId) {
        System.out.println("DAO Layer :: removeUser()");
        User existingUser = factory.getCurrentSession().find(
                User.class,userId);
        if(null != existingUser)
            factory.getCurrentSession().remove(existingUser);

        return existingUser;
    }

//    @Override
//    public Boolean isUserExist(User user) {
//        User existingUser = factory.getCurrentSession().find(
//                User.class,user.getUserId());
//        return existingUser != null && existingUser.getUserId() != 0;
//    }
}