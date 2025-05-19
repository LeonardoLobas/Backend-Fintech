package com.example.coinmappingapp.exception;

public class DBExeption extends Exception {
    public DBExeption() {
    }

    public DBExeption(String message) {
        super(message);
    }

    public DBExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public DBExeption(Throwable cause) {
        super(cause);
    }

    public DBExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
