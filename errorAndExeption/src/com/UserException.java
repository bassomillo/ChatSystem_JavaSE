package com;

public class UserException extends RuntimeException{

    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public UserException(String message, int code) {
        super(message);
        this.code = code;
    }

    public UserException() {

    }
}
