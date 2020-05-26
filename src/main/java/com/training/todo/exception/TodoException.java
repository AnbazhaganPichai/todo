package com.training.todo.exception;

/**
 * Created by GBS05161 on 26-05-2020.
 */
public class TodoException extends RuntimeException {

    public TodoException() {
        super();
    }

    public TodoException(String message) {
        super(message);
    }

    public TodoException(String message, Throwable cause) {
        super(message, cause);
    }

    public TodoException(Throwable cause) {
        super(cause);
    }

}
