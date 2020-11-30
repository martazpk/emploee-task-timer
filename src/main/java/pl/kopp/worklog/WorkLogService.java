package pl.kopp.worklog;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkLogService {
    private final WorkLogRepository workLogRepository;

    public void addAll(List<WorkLog> workLogs) {
        workLogRepository.saveAll(workLogs);
    }
}
