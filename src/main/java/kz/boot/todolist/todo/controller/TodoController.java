package kz.boot.todolist.todo.controller;

import kz.boot.todolist.todo.models.Todos;
import kz.boot.todolist.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping(value = "/alltasks")
    public ResponseEntity<?> getAllTasks(){
        List<Todos> todos = service.getAllTasks();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    @PostMapping(value = "/addTask")
    public ResponseEntity<?> addTask(@RequestBody Todos todos){
        if(todos != null){
            service.addTask(todos);
            return ResponseEntity.ok(todos);
        }
        return ResponseEntity.badRequest().body("Неправильно заполнен");
    }

    @GetMapping(value = "/alltasks/{id}")
    public ResponseEntity<?> getTask(@PathVariable(name = "id") Long id){
        Todos todo = service.getTask(id);
        if(todo != null){
            return new ResponseEntity<>(todo, HttpStatus.OK);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NOT FOUND");
    }

    @DeleteMapping(value = "/deleteTask/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable(name = "id") Long id){
        if(service.deleteTodo(id)){
            return ResponseEntity.ok().body("Success deleted");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NOT FOUND TASK TO DELETE");
    }

    @PutMapping(value = "/updateTask")
    public ResponseEntity<?> updateTask(@RequestBody Todos todo){
        if( service.updateTask(todo)){
            return ResponseEntity.ok(todo);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NOT FOUND TASK TO UPDATE");
    }

    @PutMapping(value = "/setdone/{id}")
    public ResponseEntity<?> setDone(@PathVariable(name = "id") Long id){
        if(service.taskdone(id)){
            return ResponseEntity.ok().body("SUCCESS");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NOT FOUND TASK TO SET DONE STATUS");
    }
}
