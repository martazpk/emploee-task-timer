package pl.kopp.domain;

import lombok.Value;

@Value
public class Task {
    Long id; //id of task
    String project; //project key
    String category; //task category
    Long parent; // id of parent task if parent > -1
}
