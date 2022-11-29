package com.mine.diary.exceptions;

import com.mine.diary.data.models.User;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message){
        super(message);
    }
}
