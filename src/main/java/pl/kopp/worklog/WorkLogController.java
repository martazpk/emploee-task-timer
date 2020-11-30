package pl.kopp.worklog;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kopp.task.model.service.TaskService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/worklogs")
public class WorkLogController {
    private final WorkLogService workLogService;
    private final TaskService taskService;
    private final WorkLogMapper workLogMapper;

//    @PostMapping()
//    public ResponseEntity<WorkLog> addWorkLogs(@RequestBody List<WorkLogDto> dtos, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return ResponseEntity.badRequest().build();
//        }
//        dtos.stream()
//                .map(WorkLogDto::getTaskID)
//                .map(taskService::getById)
//                .
//
//        List<WorkLog> workLogs = workLogMapper.toWorkLogs(dtos);
////        workLogService.addAll(workLogs);
//        return ResponseEntity.ok().build();
//    }
}
