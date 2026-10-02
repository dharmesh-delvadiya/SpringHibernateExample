package com.demo.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(schema = "dbo",name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name = "userName", nullable = false)
    private String userName;

    @Column(name = "emailAddress", nullable = false)
    private String emailAddress;

    @Column(name = "fullName", nullable = false)
    private String fullName;

    @Column(name = "age", nullable = false)
    private int age;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                '}';
    }
}
