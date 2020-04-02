package com.in28Minutes.rest.webservices.restwebservices.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ApiModel(description = "All details about User.")
public class User {
    private Integer id;

    @Size(min = 2, message = "Name should be longer than 2 characters.")
    @ApiModelProperty(notes = "Name should be at least 2 characters.")
    private String name;

    @Past
    @ApiModelProperty(notes = "Birthday should be in the past.")
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
