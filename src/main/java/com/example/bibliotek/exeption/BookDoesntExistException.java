package com.example.bibliotek.exeption;

public class BookDoesntExistException extends RuntimeException {
    public BookDoesntExistException(String message) {
        super(message);
    }
}
