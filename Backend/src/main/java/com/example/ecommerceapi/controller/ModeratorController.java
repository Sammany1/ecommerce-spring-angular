package com.example.ecommerceapi.controller;

import com.example.ecommerceapi.model.User;
import com.example.ecommerceapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/moderators")
public class ModeratorController {
    @Autowired
    private UserService userService;

    @PostMapping("/createAdmin")
    public User createAdmin(@RequestBody User user) {
        return userService.createAdmin(user);
    }

    @PostMapping("/createUser")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
}