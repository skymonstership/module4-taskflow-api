package sg.edu.ntu.taskflow_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sg.edu.ntu.taskflow_api.model.Summary;

@Repository
public interface SummaryRepository extends JpaRepository<Summary, Long> {
}
