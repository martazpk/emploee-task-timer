package pl.kopp.domain;

import lombok.Value;

@Value
public class WorkLog {
    String author;
    Long timeLogged;
    Long date;
    Long taskID;
}
