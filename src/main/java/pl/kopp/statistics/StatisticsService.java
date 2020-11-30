package pl.kopp.statistics;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kopp.task.model.domain.Task;
import pl.kopp.task.model.domain.TaskRepository;
import pl.kopp.worklog.WorkLog;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StatisticsService {
    private final List<Task> tasks;

    public Map<Task, Long> getTotalTimePerTask() {
        Map<Task, Long> result = new HashMap<>();

        for (Task task : tasks) {
            Long totalTime;
            Long childTimes;

            Long mainTaskTime = task.getTotalTimeLogged();

            List<Task> childTasks = getChildTasks(task.getId());

            if (childTasks.isEmpty()) {
                totalTime = mainTaskTime;
            } else {
                childTimes = childTasks.stream()
                        .map(Task::getTotalTimeLogged)
                        .reduce(0L, Long::sum);
                totalTime = mainTaskTime + childTimes;
            }
            result.put(task, totalTime);
        }
        return result;
    }

    private List<Task> getChildTasks(Long id) {
        return tasks.stream().filter(t -> t.getParent().equals(id))
                .collect(Collectors.toList());
    }

    public Map<String, Long> getTimePerProjects() {
        return tasks.stream().collect(
                Collectors.groupingBy(Task::getProject, Collectors.summingLong(Task::getTotalTimeLogged)));
    }

    public Map<String, Long> getNumberOfTasksPerProject() {
        return tasks.stream().collect(
                Collectors.groupingBy(Task::getProject, Collectors.counting()));
    }

    public Map<String, Long> getTotalTimePerUser() {
        return tasks.stream()
                .map(Task::getWorkLogs)
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(WorkLog::getAuthor, Collectors.summingLong(WorkLog::getTimeLogged)));
    }

    public Map<String, Long> getEpicTime(Long id) {
        Predicate<Task> con1 = t -> t.getId().equals(id);
        Predicate<Task> con2 = t -> t.getParent().equals(id);

        return tasks.stream()
                .filter(con1.or(con2))
                .collect(
                Collectors.groupingBy(Task::getProject, Collectors.summingLong(Task::getTotalTimeLogged)));
    }

    public Map<String, Long> getTotalTimePerDay() {
        return tasks.stream()
                .map(Task::getWorkLogs)
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(WorkLog::getDateAsString, Collectors.summingLong(WorkLog::getTimeLogged)));
    }
}
