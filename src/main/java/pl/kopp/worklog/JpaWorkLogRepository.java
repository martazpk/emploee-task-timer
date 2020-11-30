package pl.kopp.worklog;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JpaWorkLogRepository implements WorkLogRepository {
    private final SpringDataWorkLogRepository springDataWorkLogRepository;

    @Override
    public void save(WorkLog workLog) {
        springDataWorkLogRepository.save(workLog);
    }

    @Override
    public void saveAll(List<WorkLog> workLogs) {
        springDataWorkLogRepository.saveAll(workLogs);
    }
}
