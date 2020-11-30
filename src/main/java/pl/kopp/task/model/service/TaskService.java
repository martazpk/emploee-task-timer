package pl.kopp.task.model.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kopp.task.model.domain.TaskRepository;
import pl.kopp.task.model.domain.Task;
import pl.kopp.worklog.WorkLog;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TaskService {
    private final TaskRepository taskRepository;

    public void addAll(List<Task> tasks){
        taskRepository.saveAll(tasks);
    }

    public void addWorkLog(Long id, WorkLog workLog){
        Task task = taskRepository.getById(id).orElseThrow(TaskNotFoundException::new);
        task.addWorkLog(workLog);
        taskRepository.update(task);
    }
}
