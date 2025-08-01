package com.cloudvendor.cloudvendorcompleteservice.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionHandler {

    @ExceptionHandler(value = EmployeeNotFoundException.class)
    public ResponseEntity<Object> handleEmployeeNotFoundException(EmployeeNotFoundException employeeNotFoundException) {
        return new ResponseEntity<Object>(employeeNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = EmployeeAlreadyPresentException.class)
    public ResponseEntity<String> handleEmployeeAlreadyPresentException(EmployeeAlreadyPresentException employeeAlreadyPresentException) {
        return new ResponseEntity<String>(employeeAlreadyPresentException.getMessage(), HttpStatus.FOUND);
    }
}

