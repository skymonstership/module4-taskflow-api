package sg.edu.ntu.taskflow_api.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sg.edu.ntu.taskflow_api.model.Task;

// import java.util.ArrayList;
// import java.util.List;

// import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    // Store the tasks in memory. Choose either an ArrayList or a HashMap.
    // If you use an ArrayList, you will need to loop through the list to
    // find a task by its id. Write a small helper method for this.
    // Generate your own ids. A simple counter is enough.
    // Initialise your collection so it is never null.

    // private List<Task> taskList = new ArrayList<>();
    // private Long idCounter = 1L;

    // private int findTaskIndexById(Long id) {
    //     for (Task task : taskList) {
    //         if (task.getId().equals(id)) {
    //             return taskList.indexOf(task);
    //         }
    //     }
    //     return -1;
    // }

    // public Task findTaskById(Long id) {
    //     int index = findTaskIndexById(id);
    //     return index == -1 ? null : taskList.get(index);
    // }

    // public List<Task> findAllTasks() {
    //     return taskList;
    // }

    // public Task createTask(Task task) {
    //     task.setId(idCounter++);
    //     taskList.add(task);
    //     return task;
    // }

    // public Task updateTask(Long id, Task task) {
    //     Task taskToUpdate = findTaskById(id);
    //     if (taskToUpdate == null) {
    //         return null;
    //     }
    //     taskToUpdate.setTitle(task.getTitle());
    //     taskToUpdate.setDescription(task.getDescription());
    //     taskToUpdate.setPriority(task.getPriority());
    //     taskToUpdate.setStatus(task.getStatus());
    //     // taskToUpdate.setCompleted(task.getCompleted());
    //     return taskToUpdate;
    // }

    // public void deleteTask(Long id) {
    //     int index = findTaskIndexById(id);
    //     if (index == -1) {
    //         return;
    //     }
    //     taskList.remove(index);
    // }

    // public Task markTaskAsComplete(Long id) {
    //     Task task = findTaskById(id);
    //     if (task == null) {
    //         return null;
    //     }
    //     task.setCompleted(true);
    //     return task;
    // }

}
