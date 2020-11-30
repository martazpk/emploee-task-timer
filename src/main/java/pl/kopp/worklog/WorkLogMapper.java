package pl.kopp.worklog;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WorkLogMapper {

    WorkLog toWorkLog(WorkLogDto workLogDto);
    WorkLogDto toDto(WorkLog workLog);

    @IterableMapping(elementTargetType = WorkLog.class)
    List<WorkLog> toWorkLogs(List<WorkLogDto> dtos);
}
