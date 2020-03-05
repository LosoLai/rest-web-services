package com.in28Minutes.rest.webservices.restwebservices.expection;

import com.in28Minutes.rest.webservices.restwebservices.user.UserNotFoundExpection;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
        ErrorResponse response = new ErrorResponse(new Date(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundExpection.class)
    public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundExpection ex, WebRequest request) throws Exception {
        ErrorResponse response = new ErrorResponse(new Date(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity(response, HttpStatus.NOT_FOUND);
    }
}
