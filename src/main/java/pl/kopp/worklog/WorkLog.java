package pl.kopp.worklog;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.kopp.task.model.domain.Task;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkLog {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String author;
    private Long timeLogged;
    private Long date; //milliseconds
    @ManyToOne
    private Task task;
    @Transient
    private String dateAsDate;

    public String getDateAsString() {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = new Date(this.date);
        return simpleDateFormat.format(date);
    }
}
