package com.mine.diary.exceptions;

public class DiaryException extends RuntimeException {
    public DiaryException(){
        super();
    }
    public DiaryException(String message) {
        super(message);
    }
}
