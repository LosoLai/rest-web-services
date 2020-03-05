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
        users.add(new User(1, "John", new Date()));
        users.add(new User(2, "Ken", new Date()));
        users.add(new User(3, "Niko", new Date()));
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
