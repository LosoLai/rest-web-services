package com.in28Minutes.rest.webservices.restwebservices.expection;

import java.util.Date;

public class ErrorResponse {
    private Date timestamps;
    private String message;
    private String details;

    public ErrorResponse(Date timestamps, String message, String details) {
        this.timestamps = timestamps;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamps() {
        return timestamps;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
