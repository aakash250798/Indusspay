package com.akash.Indusspay.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<Object> handleException(Exception ex) {
//        Map<String, Object> body = new HashMap<>();
//        body.put("message", ex.getLocalizedMessage()+" "+ex.getMessage());

        return new ResponseEntity<>("Validation failed ", HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleException2(Exception ex) {
//        Map<String, Object> body = new HashMap<>();
//        body.put("message", ex.getLocalizedMessage()+" "+ex.getMessage());

        return new ResponseEntity<>("User not found exception ", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}