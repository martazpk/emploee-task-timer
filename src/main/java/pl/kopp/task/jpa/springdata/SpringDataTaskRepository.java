package pl.kopp.task.jpa.springdata;

import org.springframework.data.repository.CrudRepository;
import pl.kopp.task.model.domain.Task;

import java.util.List;
import java.util.Optional;

public interface SpringDataTaskRepository extends CrudRepository<Task, Long> {

    List<Task> findByParent(Long parent);
}
