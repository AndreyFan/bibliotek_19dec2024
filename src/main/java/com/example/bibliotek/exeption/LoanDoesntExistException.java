package com.example.bibliotek.exeption;

public class LoanDoesntExistException extends RuntimeException {
    public LoanDoesntExistException(String message) {
        super(message);
    }
}
