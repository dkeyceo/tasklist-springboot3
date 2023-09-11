 package com.dkey.tasklist.repository.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.dkey.tasklist.domain.task.Task;
import com.dkey.tasklist.repository.TaskRepository;

@Repository
public class TaskRepositoryImpl implements TaskRepository{

	@Override
	public Optional<Task> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> findAllByUserId(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void assignToUserById(Long taskId, Long userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Task task) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create(Task task) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
