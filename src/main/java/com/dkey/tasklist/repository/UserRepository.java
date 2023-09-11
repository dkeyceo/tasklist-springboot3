package com.dkey.tasklist.repository;

import java.util.Optional;

import com.dkey.tasklist.domain.user.User;

public interface UserRepository {
	
	Optional<User> findById(long id);
	
	Optional<User> findByUsername(String username);
	
	void update(User user);
	
	void create(User user);
	
	boolean isTaskOwner(Long userId, Long taskId);
	
	void delete(Long id);
	
}
