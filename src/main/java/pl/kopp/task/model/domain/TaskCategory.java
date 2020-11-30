package pl.kopp.task.model.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public enum  TaskCategory {
    @JsonProperty("Epic")
    EPIC(2),

    @JsonProperty("Story")
    STORY(1),

    @JsonProperty("Task")
    TASK(0),

    @JsonProperty("Sub-Task")
    SUB_TASK(-1);

    private final int priority;

    TaskCategory(int priority) {
        this.priority = priority;
    }
}
