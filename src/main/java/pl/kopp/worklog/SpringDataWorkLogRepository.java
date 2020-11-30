package pl.kopp.worklog;

import org.springframework.data.repository.CrudRepository;

public interface SpringDataWorkLogRepository extends CrudRepository<WorkLog, Long> {
}
