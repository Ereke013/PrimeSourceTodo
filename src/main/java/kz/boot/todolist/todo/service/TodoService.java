package kz.boot.todolist.todo.service;

import kz.boot.todolist.todo.models.Todos;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TodoService {

    List<Todos> getAllTasks();

    Todos addTask(Todos todo);

    Todos getTask(Long id);

    boolean updateTask(Todos todo);

    boolean deleteTodo(Long id);

    boolean taskdone(Long id);
}
