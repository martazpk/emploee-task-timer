package pl.kopp.statistics;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kopp.task.model.domain.Task;
import pl.kopp.task.model.domain.TaskRepository;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/statistics")
public class DummyStatisticsController {
    private final TaskRepository taskRepository;

    @GetMapping("/task")
    public Map<Task, Long> getTaskTotalTime() {
        List<Task> all = taskRepository.getAll();
        StatisticsService statisticsService = new StatisticsService(all);
        return statisticsService.getTotalTimePerTask();
    }

    @GetMapping("/projects/times")
    public Map<String, Long> getTimePerProjects() {
        List<Task> all = taskRepository.getAll();
        StatisticsService statisticsService = new StatisticsService(all);
        return statisticsService.getTimePerProjects();
    }

    @GetMapping("/projects/task")
    public Map<String, Long> getTasksPerProject() {
        List<Task> all = taskRepository.getAll();
        StatisticsService statisticsService = new StatisticsService(all);
        return statisticsService.getNumberOfTasksPerProject();
    }

    @GetMapping("/user/time")
    public Map<String, Long> getTimePerUser() {
        List<Task> all = taskRepository.getAll();
        StatisticsService statisticsService = new StatisticsService(all);
        return statisticsService.getTotalTimePerUser();
    }

    @GetMapping("/days/time")
    public Map<String, Long> getTotalTimePerDay() {
        List<Task> all = taskRepository.getAll();
        StatisticsService statisticsService = new StatisticsService(all);
        return statisticsService.getTotalTimePerDay();
    }




}
