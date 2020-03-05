package com.in28Minutes.rest.webservices.restwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserServiceDAO service;

    // GET /users
    @GetMapping("/users")
    public List<User> retrieveAll(){
        return service.findAll();
    }

    // GET /users/{id}
    @GetMapping("/users/{id}")
    public User findUser(@PathVariable int id){
        return service.getUser(id);
    }

    // POST /users
    @PostMapping("/users")
    public void findUser(@RequestBody User user){
        User savedUser = service.setUser(user);
    }
}
