package com.example.project.controller;

import com.example.project.dto.User;
import com.example.project.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/user")
    public User create(@RequestBody User user){
        return userService.createUser(user);
    }
    @GetMapping("/user")
    public List<User> findAll(){
        return userService.findAll();
    }
    @DeleteMapping("/user/{userId}")
    public void delete(@PathVariable int userId){
        userService.delete(userId);
    }
}
