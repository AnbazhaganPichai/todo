package com.training.todo.controller;

import com.training.todo.exception.TodoException;
import com.training.todo.interfacemodule.core.ITodoProcessor;
import com.training.todo.interfacemodule.type.Task;
import com.training.todo.interfacemodule.type.TodoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by GBS05161 on 25-05-2020.
 */
@RestController
@RequestMapping("app")
public class TodoController {

    private ITodoProcessor todoProcessor;

    @GetMapping(value = "all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllTask(){
        TodoResponse todoResponse = new TodoResponse();
        List<Task> response =todoProcessor.getAllTask();
        todoResponse.setData(response);
        todoResponse.setMessage("Success");
        return new ResponseEntity(todoResponse, HttpStatus.OK);
    }

    @GetMapping(value = "status/{status}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getTaskByStatus(@PathVariable(value = "status") String status){
        TodoResponse todoResponse = new TodoResponse();
        try {
            List<Task> response = todoProcessor.getTaskByStatus(status);
            todoResponse.setMessage("Success");
            todoResponse.setData(response);
            return new ResponseEntity(todoResponse, HttpStatus.OK);
        }catch (TodoException e){
            todoResponse.setMessage(e.getMessage());
            return new ResponseEntity(todoResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createTask(@RequestBody final Task task){
        TodoResponse todoResponse = new TodoResponse();
        Task response = todoProcessor.createTask(task);
        todoResponse.setMessage("Success");
        todoResponse.setData(response);
        return new ResponseEntity(todoResponse, HttpStatus.OK);
    }

    @PutMapping(value = "update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateTask(@RequestBody final Task task){
        TodoResponse todoResponse = new TodoResponse();
        Task response = todoProcessor.updateTask(task);
        todoResponse.setMessage("Success");
        todoResponse.setData(response);
        return new ResponseEntity(todoResponse, HttpStatus.OK);
    }

    @Autowired
    public void setTodoProcessor(ITodoProcessor todoProcessor){
        this.todoProcessor=todoProcessor;
    }
}
