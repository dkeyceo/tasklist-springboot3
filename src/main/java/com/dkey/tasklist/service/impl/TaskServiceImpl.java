package com.dkey.tasklist.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dkey.tasklist.domain.exception.ResourceNotFoundException;
import com.dkey.tasklist.domain.task.Status;
import com.dkey.tasklist.domain.task.Task;
import com.dkey.tasklist.repository.TaskRepository;
import com.dkey.tasklist.repository.UserRepository;
import com.dkey.tasklist.service.TaskService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService{

	private final TaskRepository taskRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Task getById(Long id) {
		return taskRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Task not found"));
	}

	@Override
	@Transactional(readOnly = true)
	public List<Task> getAllByUserId(Long id) {
		return taskRepository.findAllByUserId(id);
	}

	@Override
	@Transactional
	public Task update(Task task) {
		if(task.getStatus() == null) {
			task.setStatus(Status.TODO);
		}
		taskRepository.update(task);
		return task;
	}

	@Override
	@Transactional
	public Task create(Task task, Long userId) {
		task.setStatus(Status.TODO);
		taskRepository.create(task);
		taskRepository.assignToUserById(task.getId(), userId);
		return task;
	}

	@Override
	@Transactional
	public void delete(Long id) {
		taskRepository.delete(id);		
	}
	
	
}
