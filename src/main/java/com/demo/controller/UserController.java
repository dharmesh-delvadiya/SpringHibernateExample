package com.demo.controller;

import com.demo.entities.User;
import com.demo.entities.beans.ResultJson;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUser/{userId}", method = RequestMethod.GET)
    public ResultJson<User> getUser(@PathVariable("userId") Integer userId){
        ResultJson<User> result = new ResultJson<User>();
        System.out.println("CONTROLLER Layer :: getUser() :: userID :: " + userId);
        User user =  userService.getUser(userId);
        if(null != user){
            result.setStatus(HttpStatus.OK.value());
            result.setResponse(user);
            result.setMessage("User detail fetched successfully by UserId: " + user.getUserId());
        }else{
            result.setStatus(HttpStatus.NO_CONTENT.value());
            result.setResponse(null);
            result.setMessage("something went wrong...while fetching userId: " + userId);
        }
        return result;
    }


    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    public ResultJson<List<User>> getUsers(){
        ResultJson<List<User>> result = new ResultJson<List<User>>();
        System.out.println("CONTROLLER Layer :: getUsers() ");
        List<User> users =  userService.getUsers();
        if(null != users && !users.isEmpty()){
            result.setStatus(HttpStatus.OK.value());
            result.setResponse(users);
            result.setMessage("All Users fetched successfully");
        }else{
            result.setStatus(HttpStatus.NO_CONTENT.value());
            result.setResponse(null);
            result.setMessage("something went wrong...while fetching all users");
        }
        return result;
    }


    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ResultJson<User> addUser(@RequestBody User user){
        ResultJson<User> result = new ResultJson<User>();
        System.out.println("CONTROLLER Layer :: addUser() :: user with userName: " + user.getUserName());
        User createdUser =  userService.addUser(user);
        if(null != createdUser){
            result.setStatus(HttpStatus.CREATED.value());
            result.setResponse(createdUser);
            result.setMessage("User created successfully UserId: " + createdUser.getUserId());
        }else{
            result.setStatus(HttpStatus.BAD_REQUEST.value());
            result.setResponse(null);
            result.setMessage("something went wrong...while creating user");
        }
        return result;
    }


    @RequestMapping(value = "/removeUser/{userId}", method = RequestMethod.DELETE)
    public ResultJson<User> removeUser(@PathVariable("userId") Integer userId){
        ResultJson<User> result = new ResultJson<User>();

        System.out.println("CONTROLLER Layer :: removeUser() :: user with userId: " + userId);
        User removedUser = userService.removeUser(userId);

        if(null != removedUser){
            result.setStatus(HttpStatus.OK.value());
            result.setResponse(removedUser);
            result.setMessage("User Deleted successfully UserId: " + removedUser.getUserId());
        }else {
            result.setStatus(HttpStatus.NOT_FOUND.value());
            result.setResponse(null);
            result.setMessage("User not exist");
        }
        return result;
    }

}
