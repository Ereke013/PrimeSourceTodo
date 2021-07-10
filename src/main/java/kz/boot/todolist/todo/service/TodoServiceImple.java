package kz.boot.todolist.todo.service;

import kz.boot.todolist.todo.models.Todos;
import kz.boot.todolist.todo.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TodoServiceImple implements TodoService{

    @Autowired
    private TodoRepository repository;

    @Override
    public List<Todos> getAllTasks() {
        return repository.findAll();
    }

    @Override
    public Todos addTask(Todos todo) {
        if(todo!= null){
            todo.setDone(0);
            return repository.save(todo);
        }
        return null;
    }

    @Override
    public Todos getTask(Long id) {
        if(repository.findById(id).isEmpty()){
            return null;
        }
        return repository.findById(id).get();
    }

    @Override
    public boolean updateTask(Todos todo) {
        Todos todos = getTask(todo.getId());
        if(todos != null){
            repository.save(todo);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteTodo(Long id) {
        Todos todo = getTask(id);
        if(todo != null){
            repository.delete(todo);
            return true;
        }
        return false;
    }

    @Override
    public boolean taskdone(Long id) {
        Todos todos = getTask(id);
        if(todos != null){
            todos.setDone(1);
            repository.save(todos);
            return true;
        }
        return false;
    }
}
