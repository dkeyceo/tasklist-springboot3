package com.dkey.tasklist.service.impl;

import org.springframework.stereotype.Service;

import com.dkey.tasklist.domain.user.User;
import com.dkey.tasklist.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Override
	public User getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User update(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User create(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isTaskOwner(Long userId, Long taskId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
