package pl.kopp.task.controller;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import pl.kopp.task.model.domain.Task;
import pl.kopp.task.model.dto.TaskDto;
import pl.kopp.worklog.WorkLogMapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {WorkLogMapper.class})
public interface TaskMapper {

    Task toTask(TaskDto taskDto);
    TaskDto toDto(Task task);

    @IterableMapping(elementTargetType = Task.class)
    List<Task> toTasks(List<TaskDto> users);
}
