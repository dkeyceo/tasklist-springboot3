package com.dkey.tasklist.service;

import java.util.List;

import com.dkey.tasklist.domain.task.Task;

public interface TaskService {
	
	Task getById(Long id);
	
	List<Task> getAllByUserId(Long id);
	
	Task update(Task task);
	
	Task create(Task task, Long userId);
	
	void delete(Long id);
}
