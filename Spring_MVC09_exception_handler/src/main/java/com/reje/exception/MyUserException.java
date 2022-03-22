package com.reje.exception;

public class MyUserException extends Exception {
    //ctrl+o重写父类的方法
    public MyUserException() {
        super();
    }

    public MyUserException(String message) {
        super(message);
    }
}
