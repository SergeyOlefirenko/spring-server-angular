package spring.angular.controller;

import lombok.*;
import org.springframework.web.bind.annotation.*;
import spring.angular.model.Task;
import spring.angular.repository.TaskRepository;

import java.util.List;

@Data
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TaskController {

    // standard constructors

    private final TaskRepository taskRepository;

    @GetMapping("/tasks")
    public List<Task> getUsers() {
        return (List<Task>) taskRepository.findAll();
    }

    @PostMapping("/tasks")
    void addTask(@RequestBody Task task) {
        taskRepository.save(task);
    }
}

