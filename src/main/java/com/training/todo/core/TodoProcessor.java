package com.training.todo.core;

import com.training.todo.exception.TodoException;
import com.training.todo.interfacemodule.core.ITodoProcessor;
import com.training.todo.interfacemodule.type.Task;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GBS05161 on 25-05-2020.
 */
@Component
public class TodoProcessor implements ITodoProcessor{

    public Task createTask(Task task) {
        return task;
    }

    public Task updateTask(Task task) {
        return task;
    }

    public List<Task> getTaskByStatus(String status) {
        List<Task> responseTaskList = new ArrayList<Task>();
        List<Task> taskList= getTaskList();
        for (Task task: taskList){
            Task task1= new Task();
            if (task.getStatus().equalsIgnoreCase(status)){
                task1.setTaskName(task.getTaskName());
                task1.setStatus(task.getStatus());
                task1.setDueDate(task.getDueDate());
                responseTaskList.add(task1);
            }
        }
        if (responseTaskList.isEmpty()){
            throw new TodoException("There is no Task available for your search");
        }
        return responseTaskList;
    }

    public List<Task> getAllTask() {
        return getTaskList();
    }

    private List<Task> getTaskList(){
        List<Task> taskList = new ArrayList<Task>();
        Task task1=new Task("Todo", "develop App", "28/05/2020");
        Task task2=new Task("Todo", "Develop Api", "27/05/2020");
        Task task3=new Task("Done", "Design Todo App", "25/05/2020");
        taskList.add(task1);
        taskList.add(task2);
        taskList.add(task3);
        return taskList;
    }
}
