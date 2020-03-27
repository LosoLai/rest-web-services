package com.in28Minutes.rest.webservices.restwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
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
    public Resource<User> findUser(@PathVariable int id) {
        User user = service.getUser(id);
        if(user == null)
            throw new UserNotFoundExpection("id-" + id);

        //HATEOAS
        Resource<User> resource = new Resource<User>(user);
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAll());
        resource.add(linkTo.withRel("all-user"));
        return resource;
    }

    // POST /users
    @PostMapping("/users")
    public ResponseEntity<Object> saveUser(@Valid @RequestBody User user) {
        User savedUser = service.setUser(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    // DELETE /users
    @DeleteMapping("/users/{id}")
    public void deleteUserByID(@PathVariable int id) {
        User deletedUser = service.deleteUser(id);
        if (deletedUser == null)
            throw new UserNotFoundExpection("id-" + id);
    }

    //GET /users/{id}/posts
    @GetMapping("/users/{id}/posts")
    public List<Post> retrieveAllPostByUserID(@PathVariable int id) {
        User user = service.getUser(id);
        if(user == null)
            throw new UserNotFoundExpection("id-" + id);
        return user.getPosts();
    }

    //POST /users/{id}/posts
    @PostMapping("/users/{id}/posts")
    public User createPostForUser(@PathVariable int id) {
        User user = service.getUser(id);
        Post post = new Post("Automatic Post");
        user.createPost(post);
        if(user == null)
            throw new UserNotFoundExpection("id-" + id);
        return user;
    }

    //GET /users/{id}/posts/{post_id}
    @GetMapping("/users/{id}/posts/{post_id}")
    public Post getPostFormUser(@PathVariable int id,
                                @PathVariable int post_id) {
        User user = service.getUser(id);
        Post post = user.getPosts().get(post_id);
        if(user == null)
            throw new UserNotFoundExpection("id-" + id);
        return post;
    }
}
