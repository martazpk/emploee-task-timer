package pl.kopp.task.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public enum TaskCategoryDto {
    @JsonProperty("Epic")
    EPIC,
    @JsonProperty("Story")
    STORY,
    @JsonProperty("Task")
    TASK,
    @JsonProperty("Sub-Task")
    SUB_TASK;
}
