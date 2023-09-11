package com.dkey.tasklist.web.controllers;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dkey.tasklist.domain.task.Task;
import com.dkey.tasklist.domain.user.User;
import com.dkey.tasklist.service.TaskService;
import com.dkey.tasklist.service.UserService;
import com.dkey.tasklist.web.dto.task.TaskDto;
import com.dkey.tasklist.web.dto.user.UserDto;
import com.dkey.tasklist.web.dto.validation.OnCreate;
import com.dkey.tasklist.web.dto.validation.OnUpdate;
import com.dkey.tasklist.web.mappers.TaskMapper;
import com.dkey.tasklist.web.mappers.UserMapper;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Validated
public class UserController {
	
	private final UserService userService;
	private final TaskService taskService;
	
	private final UserMapper userMapper;
	private final TaskMapper taskMapper;
	
	@PutMapping
	public UserDto update(@Validated(OnUpdate.class) @RequestBody UserDto userDto) {
		
		User user = userMapper.toEntity(userDto);
		User updatedUser = userService.update(user);
		return userMapper.toDto(updatedUser);
	}
	
	@GetMapping("/{id}")
	public UserDto getById(@PathVariable Long id) {
		User user = userService.getById(id);
		return userMapper.toDto(user);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		userService.delete(id);
	}
	
	@GetMapping("/{id}/tasks")
	public List<TaskDto> getTasksByUserId(@PathVariable Long id){
		List<Task> tasks = taskService.getAllByUserId(id);
		return taskMapper.toDto(tasks);
	}
	
	@PostMapping("/{id}/tasks")
	public TaskDto createTask(@PathVariable Long id, @Validated(OnCreate.class) @RequestBody TaskDto taskDto) {
		Task task = taskMapper.toEntity(taskDto);
		Task createdTask = taskService.create(task, id);
		return taskMapper.toDto(createdTask);
	}
}
