package pl.kopp.task.model.domain;

import org.junit.jupiter.api.Test;
import pl.kopp.worklog.WorkLog;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void getTotalTimeLogged() {
        Task task = givenTask();
        Long totalTimeLogged = task.getTotalTimeLogged();

        assertEquals(10L, totalTimeLogged);
    }

    private Task givenTask() {
        Task task = new Task();
        WorkLog workLog1 = WorkLog.builder().timeLogged(1L).build();
        WorkLog workLog2 = WorkLog.builder().timeLogged(2L).build();
        WorkLog workLog3 = WorkLog.builder().timeLogged(3L).build();
        WorkLog workLog4 = WorkLog.builder().timeLogged(4L).build();

        task.setWorkLogs(List.of(workLog1, workLog2, workLog3, workLog4));
        return task;
    }
}