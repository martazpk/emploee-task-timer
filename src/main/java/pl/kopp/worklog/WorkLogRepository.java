package pl.kopp.worklog;

import java.util.List;

public interface WorkLogRepository {
    void save(WorkLog workLog);
    void saveAll(List<WorkLog> workLogs);
}
