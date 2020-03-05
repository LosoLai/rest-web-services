package com.in28Minutes.rest.webservices.restwebservices.helloworld;

public class HelloWorldBean {
    private final String message;

    public HelloWorldBean(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
