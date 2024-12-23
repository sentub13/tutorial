package com.pxp.SQLite.demo.controller;

import com.pxp.SQLite.demo.entity.User;
import com.pxp.SQLite.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createUser(@RequestBody User user) {
        return userService.createUser(user);
    };
    
    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public List<User> readUser() {
        return userService.readUser();
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String deleteUser(@RequestBody User user){
        return userService.deleteUser(user);
    }



}
