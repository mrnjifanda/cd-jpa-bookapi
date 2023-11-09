package com.seven.academy.mvc.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.seven.academy.mvc.models.User;
import com.seven.academy.mvc.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UsersApi {

    private UserService userService;

    public UsersApi(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("")
    public List<User> allUsers() {

        return this.userService.find();
    }

    @PostMapping("/create")
    public User createUser(
        @RequestParam(value = "username") String username,
        @RequestParam(value = "email") String email,
        @RequestParam(value = "password") String password
    ) {

        System.out.println(username);
        System.out.println(email);
        System.out.println(password);

        User user = new User(username, email, password);
        return this.userService.create(user);
    }
}
