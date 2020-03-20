package com.in28Minutes.rest.webservices.restwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {
    private Integer id;
    private String name;
    private Date birthDate;
    private List<Post> posts;

    public User(Integer id, String name, Date birthDate){
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        posts = new ArrayList<Post>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void createPost(Post post) {
        this.posts.add(post);
    }

    @Override
    public String toString(){
        return String.format("%d - %s - %s", id, name, birthDate);
    }
}
