package pl.kopp.task.statistics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.kopp.statistics.StatisticsService;
import pl.kopp.task.model.domain.Task;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.kopp.task.statistics.TestData.*;

class StatisticsServiceTest {
    private StatisticsService statisticsService;

    @BeforeEach
    void setUp() {
        List<Task> tasks = aTaskList();
        statisticsService = new StatisticsService(tasks);
    }

    @Test
    void shouldReturnTotalTimePerTaskIncludedChildTasks() {
        Map<Task, Long> totalTimePerTask = statisticsService.getTotalTimePerTask();

        assertThat(totalTimePerTask.size()).isEqualTo(3);
        assertThat(totalTimePerTask.values()).contains(18L);
    }

    @Test
    void shouldReturnTotalTimePerTask() {
        Map<String, Long> result = statisticsService.getTimePerProjects();

        assertThat(result.get(PROJECT_NAME_1)).isEqualTo(12L);
        assertThat(result.get(PROJECT_NAME_2)).isEqualTo(12L);
    }

    @Test
    void shouldReturnNumberOfTasksPerProject() {
        Map<String, Long> result = statisticsService.getNumberOfTasksPerProject();

        assertThat(result.get(PROJECT_NAME_1)).isEqualTo(2L);
        assertThat(result.get(PROJECT_NAME_2)).isEqualTo(1L);
    }

    @Test
    void shouldReturnTotalLoggedTimePerAuthor() {
        Map<String, Long> result = statisticsService.getTotalTimePerUser();

        assertThat(result.get(AUTHOR_1)).isEqualTo(11L);
        assertThat(result.get(AUTHOR_2)).isEqualTo(8L);
    }

    @Test
    void shouldReturnTotalLoggedTimePerDay() {
        Map<String, Long> result = statisticsService.getTotalTimePerDay();

        assertThat(result.get("2020-09-18")).isEqualTo(5L);
    }
}