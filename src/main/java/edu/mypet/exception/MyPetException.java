package edu.mypet.exception;

public class MyPetException extends Exception{
    public MyPetException() {
    }

    public MyPetException(String message) {
        super(message);
    }

    public MyPetException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyPetException(Throwable cause) {
        super(cause);
    }

    public MyPetException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
