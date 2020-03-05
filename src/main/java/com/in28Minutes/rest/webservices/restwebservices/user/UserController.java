package com.in28Minutes.rest.webservices.restwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserServiceDAO service;

    // GET /users
    @GetMapping("/users")
    public List<User> retrieveAll() {
        return service.findAll();
    }

    // GET /users/{id}
    @GetMapping("/users/{id}")
    public User findUser(@PathVariable int id) {
        User user = service.getUser(id);
        if(user == null)
            throw new UserNotFoundExpection("id-" + id);
        return user;
    }

    // POST /users
    @PostMapping("/users")
    public ResponseEntity<Object> saveUser(@RequestBody User user) {
        User savedUser = service.setUser(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
