package edu.gorb.array.exception;

public class ValidityException extends Exception {
    public ValidityException() {
    }

    public ValidityException(String message) {
        super(message);
    }

    public ValidityException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidityException(Throwable cause) {
        super(cause);
    }
}
