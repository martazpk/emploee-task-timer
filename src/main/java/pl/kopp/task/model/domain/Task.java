package pl.kopp.task.model.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.kopp.worklog.WorkLog;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Task {
    @Id
    private Long id;
    private String project;
    @Enumerated(EnumType.STRING)
    private TaskCategory category;
    private Long parent; // id of parent task if parent > -1
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<WorkLog> workLogs;

    public void addWorkLog(WorkLog workLog){
        if(workLogs == null){
            workLogs = new ArrayList<>();
        }
        workLogs.add(workLog);
    }

    public Long getTotalTimeLogged(){
        return workLogs.stream()
                .map(WorkLog::getTimeLogged)
                .reduce(0L, Long::sum);
    }
}
