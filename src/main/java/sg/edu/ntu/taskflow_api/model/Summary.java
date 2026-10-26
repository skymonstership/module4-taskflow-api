package sg.edu.ntu.taskflow_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "summaries")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Summary {

    @Id
    private Long id = 1L; // 唯一全局摘要记录 ID

    @Column(columnDefinition = "TEXT")
    private String summaryText; // 摘要文本内容

    private LocalDateTime generatedAt; // 生成时间戳
}
