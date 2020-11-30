package pl.kopp.task.model.dto;

import lombok.Data;
import pl.kopp.task.model.dto.TaskCategoryDto;

@Data
public class TaskDto {
    Long id;
    String project;
    TaskCategoryDto category;
    Long parent;
}
