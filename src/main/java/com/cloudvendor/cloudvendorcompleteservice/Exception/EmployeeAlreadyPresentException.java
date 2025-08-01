package com.cloudvendor.cloudvendorcompleteservice.Exception;

public class EmployeeAlreadyPresentException extends RuntimeException{
    public EmployeeAlreadyPresentException(String message) {
        super(message);
    }

    public EmployeeAlreadyPresentException(String message, Throwable cause) {
        super(message, cause);
    }
}
