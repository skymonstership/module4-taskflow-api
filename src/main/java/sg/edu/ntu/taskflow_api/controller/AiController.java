package sg.edu.ntu.taskflow_api.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.ntu.taskflow_api.model.Summary;
import sg.edu.ntu.taskflow_api.model.Task;
import sg.edu.ntu.taskflow_api.service.TaskService;

@CrossOrigin(origins = "${FRONTEND_URL:http://localhost:5173}")
@RestController
@RequestMapping("/api/tasks")
public class AiController {
    // • Create a ChatClient and inject it where you need it.
    private final ChatClient chatClient;
    private final TaskService taskService;

    public AiController(ChatClient.Builder chatClientBuilder, TaskService taskService) {
        this.chatClient = chatClientBuilder.build();
        this.taskService = taskService;
    }

    // • Add an endpoint at GET /api/tasks/summary.
    @GetMapping("/summary")
    // It should take your list of tasks, send it to the model,
    // and return a short plain-English summary of what is pending
    // and what is done.
    public ResponseEntity<Summary> summary() {
        List<Task> tasks = taskService.findAllTasks();
        StringBuilder allTask = new StringBuilder("Here is my task list:\n");
        for (Task task : tasks) {
            allTask.append("- Title: ").append(task.getTitle())
                    .append(", Description: ").append(task.getDescription())
                    .append(", Priority: ").append(task.getPriority())
                    // .append(", Completed: ").append(task.getCompleted()).append("\n");
                    .append(", Status: ").append(task.getStatus()).append("\n");
        }
        String summaryText = chatClient.prompt()
                .system("Summarize the following tasks in plain English:\n" + allTask.toString())
                .user(allTask.toString())
                .call()
                .content();

        Summary summary = new Summary(1L, summaryText, LocalDateTime.now());
        taskService.saveSummary(summary);

        return new ResponseEntity<>(summary, HttpStatus.OK);
    }

    @GetMapping("/summary/cached")
    public ResponseEntity<Summary> getCachedSummary() {
        Summary summary = taskService.getTaskSummary();
        return new ResponseEntity<>(summary, HttpStatus.OK);

    }
}
