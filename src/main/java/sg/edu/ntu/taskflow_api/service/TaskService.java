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
        return taskRepository.findAll();
    }

// •	findTaskById(Long id)
    public Task findTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

// •	createTask(Task task)
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

// •	updateTask(Long id, Task task)
    public Task updateTask(Long id, Task task) {
        Task existingTask = taskRepository.findById(id).orElse(null);
        if (existingTask == null) {
            return null;
        }
        existingTask.setTitle(task.getTitle());
        existingTask.setDescription(task.getDescription());
        existingTask.setPriority(task.getPriority());
        existingTask.setStatus(task.getStatus());
        return taskRepository.save(existingTask);
    }

// •	deleteTask(Long id)
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

// // •	markTaskAsComplete(Long id) 'in-progress' | 'done'
//     public Task markTaskAsComplete(Long id) {
// // For markTaskAsComplete, find the task, set its completed flag to true, and save it back.
// // Use constructor injection to bring the repository into the service.
//         return taskRepository.markTaskAsComplete(id);
//     }
}
