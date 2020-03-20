package com.in28Minutes.rest.webservices.restwebservices.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserServiceDAO {
    private static List<User> users = new ArrayList<User>();
    private static int userCount = 3;

    static {
        User user = new User(1, "John", new Date());
        user.createPost(new Post("POST 01"));
        users.add(user);
        user = new User(2, "Ken", new Date());
        user.createPost(new Post("POST 02"));
        users.add(user);
        user = new User(3, "Niko", new Date());
        user.createPost(new Post("POST 03"));
        users.add(user);
    }

    public List<User> findAll(){
        return users;
    }

    public User setUser(User user){
        if(user.getId() == null){
            user.setId(++userCount);
        }
        users.add(user);
        return user;
    }

    public User getUser(int id){
        for(User user : users){
            if(user.getId() == id)
                return user;
        }
        return null;
    }
}
