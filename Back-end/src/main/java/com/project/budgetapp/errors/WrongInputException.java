package com.project.budgetapp.errors;

public class WrongInputException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public WrongInputException(String msg) {
        super(msg);
    }
}
