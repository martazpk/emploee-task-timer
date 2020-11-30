package pl.kopp.worklog;

import lombok.Data;

@Data
public class WorkLogDto {
    private Long id;
    private String author;
    private Long timeLogged;
    private Long date;
    private Long taskID;
}
