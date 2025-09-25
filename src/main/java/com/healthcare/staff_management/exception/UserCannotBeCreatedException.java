package com.healthcare.staff_management.exception;

public class UserCannotBeCreatedException extends RuntimeException{
    public UserCannotBeCreatedException() {
        super("Error when creating new user");
    }
}
