package sg.edu.ntu.taskflow_api.model;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Data
@NoArgsConstructor
// @JsonPropertyOrder({"id", "title", "description", "priority", "completed"})
@JsonPropertyOrder({"id", "title", "description", "priority", "status"})

public class Task {
    private Long id;
    private String title;
    private String description;
    private String priority;
    // private String completed;
    private String status;

    public Task(String title, String description,
        // String priority, String completed) {
        String priority, String status) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        // this.completed = completed;
        this.status = status;
    }
}