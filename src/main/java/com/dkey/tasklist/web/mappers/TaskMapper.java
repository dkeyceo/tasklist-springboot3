package com.dkey.tasklist.web.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.dkey.tasklist.domain.task.Task;
import com.dkey.tasklist.web.dto.task.TaskDto;

@Mapper(componentModel = "spring")
public interface TaskMapper {
	
	TaskDto toDto(Task task);
	
	List<TaskDto> toDto(List<Task> tasks);
	
	Task toEntity(TaskDto taskDto);
}
