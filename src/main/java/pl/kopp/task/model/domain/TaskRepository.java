package pl.kopp.task.model.domain;
import java.util.List;
import java.util.Optional;

public interface TaskRepository {
    void update(Task task);
    void saveAll(List<Task> tasks);
    Optional<Task> getById(Long id);
    List<Task> findByParent(Long id);
    List<Task> getAll();
}
