package com.training.todo.interfacemodule.type;

/**
 * Created by GBS05161 on 26-05-2020.
 */
public class TodoResponse {
    private Object data;
    private String message;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
