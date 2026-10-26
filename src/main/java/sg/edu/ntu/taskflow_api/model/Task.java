package sg.edu.ntu.taskflow_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@Table(name = "tasks")
@Data
@NoArgsConstructor
// @JsonPropertyOrder({"id", "title", "description", "priority", "completed"})
@JsonPropertyOrder({"id", "title", "description", "priority", "status"})

public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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