package com.training.todo.interfacemodule.type;

/**
 * Created by GBS05161 on 25-05-2020.
 */
public class Task {
    private String status;
    private String taskName;
    private String dueDate;

    public Task() {
    }

    public Task(String status, String taskName, String dueDate) {
        this.status = status;
        this.taskName = taskName;
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}
