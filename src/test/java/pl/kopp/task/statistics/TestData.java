package pl.kopp.task.statistics;

import pl.kopp.task.model.domain.Task;
import pl.kopp.worklog.WorkLog;

import java.util.Arrays;
import java.util.List;

public class TestData {
    public static final String PROJECT_NAME_1 = "D";
    public static final String PROJECT_NAME_2 = "B";
    public static final String AUTHOR_1 = "Marta";
    public static final String AUTHOR_2 = "Ola";
    public static final String AUTHOR_3 = "Kasia";

    public static List<Task> aTaskList() {
        return Arrays.asList(aTask1(), aTask2(), aTask3());
    }

    private static Task aTask1() {
        Task task = new Task();
        task.setId(1L);
        task.setParent(-1L);
        task.setWorkLogs(aWorkLogs1());
        task.setProject(PROJECT_NAME_1);
        return task;
    }

    private static Task aTask2() {
        Task task = new Task();
        task.setParent(1L);
        task.setWorkLogs(aWorkLogs2());
        task.setProject(PROJECT_NAME_2);
        return task;
    }

    private static Task aTask3() {
        Task task = new Task();
        task.setId(3L);
        task.setParent(-1L);
        task.setWorkLogs(aWorkLogs1());
        task.setProject(PROJECT_NAME_1);
        return task;
    }

    public static List<WorkLog> aWorkLogs1() {
        WorkLog workLog1 = WorkLog.builder().timeLogged(1L).author(AUTHOR_1).date(1598130486932L).build();
        WorkLog workLog2 = WorkLog.builder().timeLogged(2L).author(AUTHOR_2).date(1598130486932L).build();
        WorkLog workLog3 = WorkLog.builder().timeLogged(3L).author(AUTHOR_1).date(1599443466595L).build();
        return Arrays.asList(workLog1, workLog2, workLog3);
    }

    public static List<WorkLog> aWorkLogs2() {
        WorkLog workLog1 = WorkLog.builder().timeLogged(3L).author(AUTHOR_1).date(1605025806935L).build();
        WorkLog workLog2 = WorkLog.builder().timeLogged(4L).author(AUTHOR_2).date(1598153106183L).build();
        WorkLog workLog3 = WorkLog.builder().timeLogged(5L).author(AUTHOR_3).date(1600405446568L).build();
        return Arrays.asList(workLog1, workLog2, workLog3);
    }
}
