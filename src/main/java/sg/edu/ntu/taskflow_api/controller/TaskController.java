package sg.edu.ntu.taskflow_api.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.ntu.taskflow_api.service.TaskService;
import sg.edu.ntu.taskflow_api.model.Task;

@CrossOrigin(origins = "https://skymonstership-taskflow-app.netlify.app")
@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // GET /api/tasks Get all tasks
    @GetMapping()
    public ResponseEntity<List<Task>> findAllTasks() {
        List<Task> allTasks = taskService.findAllTasks();
        return new ResponseEntity<>(allTasks, HttpStatus.OK);
    }

    // GET /api/tasks/{id} Get one task by id
    @GetMapping("/{id}")
    public ResponseEntity<Task> findTaskById(@PathVariable Long id) {
        Task foundTask = taskService.findTaskById(id);
        return new ResponseEntity<>(foundTask, HttpStatus.OK);
    }

    // POST /api/tasks Create a new task
    @PostMapping()
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task createdTask = taskService.createTask(task);
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

    // PUT /api/tasks/{id} Update an existing task
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
        Task updatedTask = taskService.updateTask(id, task);
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }

    // DELETE /api/tasks/{id} Delete a task
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // PUT /api/tasks/{id}/complete Mark a task as complete
    // Return the correct status codes. 201 for create, 200 for the rest.
    // Use constructor injection to bring the service into the controller.
    @PutMapping("/{id}/complete")
    public ResponseEntity<Task> markTaskAsComplete(@PathVariable Long id) {
        Task completedTask = taskService.markTaskAsComplete(id);
        return new ResponseEntity<>(completedTask, HttpStatus.OK);

    }
}
