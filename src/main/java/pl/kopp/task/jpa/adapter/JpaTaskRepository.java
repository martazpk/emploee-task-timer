package pl.kopp.task.jpa.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.kopp.task.model.domain.TaskRepository;
import pl.kopp.task.jpa.springdata.SpringDataTaskRepository;
import pl.kopp.task.model.domain.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JpaTaskRepository implements TaskRepository {
    private final SpringDataTaskRepository springDataTaskRepository;

    @Override
    public void update(Task task) {
        springDataTaskRepository.save(task);
    }

    @Override
    public void saveAll(List<Task> tasks) {
        springDataTaskRepository.saveAll(tasks);
    }

    @Override
    public Optional<Task> getById(Long id) {
        return springDataTaskRepository.findById(id);
    }

    @Override
    public List<Task> findByParent(Long id) {
        return springDataTaskRepository.findByParent(id);
    }

    @Override
    public List<Task> getAll() {
        Iterable<Task> iterable = springDataTaskRepository.findAll();
        List<Task> target = new ArrayList<>();
        iterable.forEach(target::add);
        return target;
    }
}
