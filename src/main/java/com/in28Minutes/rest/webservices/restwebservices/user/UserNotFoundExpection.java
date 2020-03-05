package com.in28Minutes.rest.webservices.restwebservices.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundExpection extends RuntimeException{
    public UserNotFoundExpection(String message) {
        super(message);
    }
}
