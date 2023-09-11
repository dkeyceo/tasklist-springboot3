package com.dkey.tasklist.web.controllers;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dkey.tasklist.domain.task.Task;
import com.dkey.tasklist.service.TaskService;
import com.dkey.tasklist.web.dto.task.TaskDto;
import com.dkey.tasklist.web.dto.validation.OnUpdate;
import com.dkey.tasklist.web.mappers.TaskMapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
@Validated
public class TaskController {
	
	private final TaskService taskService;
	
	private final TaskMapper taskMapper;
	
	@PutMapping
	public TaskDto update(@Validated(OnUpdate.class) @RequestBody TaskDto taskDto) {
		Task task = taskMapper.toEntity(taskDto);
		Task updatedTask = taskService.update(task);
		return taskMapper.toDto(updatedTask);
	}
	
	@GetMapping("/{id}")
	public TaskDto getById(@PathVariable Long id) {
		Task task = taskService.getById(id);
		return taskMapper.toDto(task);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		taskService.delete(id);
	}
	
}
