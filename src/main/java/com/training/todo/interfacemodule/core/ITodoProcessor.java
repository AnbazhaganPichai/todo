package com.training.todo.interfacemodule.core;

import com.training.todo.interfacemodule.type.Task;

import java.util.List;

/**
 * Created by GBS05161 on 25-05-2020.
 */
public interface ITodoProcessor {

    public Task createTask(Task task);
    public Task updateTask(Task task);
    public List<Task> getTaskByStatus(String status);
    public List<Task> getAllTask();
}
