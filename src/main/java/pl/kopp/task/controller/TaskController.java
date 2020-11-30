package pl.kopp.task.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.kopp.task.model.domain.Task;
import pl.kopp.task.model.dto.TaskDto;
import pl.kopp.task.model.service.TaskService;
import pl.kopp.worklog.WorkLog;
import pl.kopp.worklog.WorkLogDto;
import pl.kopp.worklog.WorkLogMapper;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;
    private final TaskMapper taskMapper;
    private final WorkLogMapper workLogMapper;

    @PostMapping()
    public ResponseEntity<Task> addTasks(@RequestBody List<TaskDto> taskDtos, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
        List<Task> tasks = taskMapper.toTasks(taskDtos);
        taskService.addAll(tasks);
        return ResponseEntity.ok().build();
    }

    @PutMapping("update/workLog")
    public ResponseEntity<Task> addWorkLog(@RequestBody WorkLogDto dto, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
        WorkLog workLog = workLogMapper.toWorkLog(dto);
        taskService.addWorkLog(dto.getTaskID(), workLog);
        return ResponseEntity.ok().build();
    }

    @PutMapping("updateAll/workLog")
    public ResponseEntity<Task> addWorkLog(@RequestBody List<WorkLogDto> dtos, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
        for(WorkLogDto dto: dtos){
            WorkLog workLog = workLogMapper.toWorkLog(dto);
            taskService.addWorkLog(dto.getTaskID(),workLog);
        }
        return ResponseEntity.ok().build();
    }
}
