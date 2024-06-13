package com.akash.Indusspay.controller;


import com.akash.Indusspay.model.User;
import com.akash.Indusspay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping("/get/{id}")
    public User getById(@PathVariable int id) throws Exception{
        return service.getUser(id);
    }

//    @GetMapping("/get")
//    public List<User> getAll()throws Exception{
//        return service.getAllUsers();
//    }

    @PostMapping("/add")
    public User createUser(@RequestBody User user)throws Exception{
        return service.addUser(user);
    }


}
