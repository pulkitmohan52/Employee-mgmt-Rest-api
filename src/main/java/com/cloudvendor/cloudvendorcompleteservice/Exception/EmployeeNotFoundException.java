package com.cloudvendor.cloudvendorcompleteservice.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(String message) {
        super(message);
    }

    public EmployeeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
