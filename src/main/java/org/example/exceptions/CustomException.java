package org.example.exceptions;

public class CustomException extends RuntimeException{
    private final String message;

    @Override
    public String getMessage() {
        return message;
    }

    public CustomException(String message) {
        this.message = message;
    }
}
