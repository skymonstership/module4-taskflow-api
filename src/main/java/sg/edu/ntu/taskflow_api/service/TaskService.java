package sg.edu.ntu.taskflow_api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import sg.edu.ntu.taskflow_api.repository.TaskRepository;
import sg.edu.ntu.taskflow_api.model.Task;

@Service 
public class TaskService {
    
// The service holds your business logic and calls the repository. Write these methods:
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

// •	findAllTasks()
    public List<Task> findAllTasks() {
        return taskRepository.findAllTasks();
    }

// •	findTaskById(Long id)
    public Task findTaskById(Long id) {
        return taskRepository.findTaskById(id);
    }

// •	createTask(Task task)
    public Task createTask(Task task) {
        return taskRepository.createTask(task);
    }

// •	updateTask(Long id, Task task)
    public Task updateTask(Long id, Task task) {
        return taskRepository.updateTask(id, task);
    }

// •	deleteTask(Long id)
    public void deleteTask(Long id) {
        taskRepository.deleteTask(id);
    }

// // •	markTaskAsComplete(Long id) 'in-progress' | 'done'
//     public Task markTaskAsComplete(Long id) {
// // For markTaskAsComplete, find the task, set its completed flag to true, and save it back.
// // Use constructor injection to bring the repository into the service.
//         return taskRepository.markTaskAsComplete(id);
//     }
}
