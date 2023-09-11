package com.dkey.tasklist.repository.impl;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.dkey.tasklist.domain.user.User;
import com.dkey.tasklist.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository{

	@Override
	public Optional<User> findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<User> findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create(User user) {
		// TODO Auto-generated method stub
		
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
