package com.dkey.tasklist.service.impl;

import java.util.Set;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dkey.tasklist.domain.exception.ResourceNotFoundException;
import com.dkey.tasklist.domain.user.Role;
import com.dkey.tasklist.domain.user.User;
import com.dkey.tasklist.repository.UserRepository;
import com.dkey.tasklist.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
	
	private final UserRepository userRepository;

	private final PasswordEncoder passwordEncoder;
	
	@Override
	@Transactional(readOnly = true)
	public User getById(Long id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found"));
	}

	@Override
	@Transactional(readOnly = true)
	public User getByUsername(String username) {		
		return userRepository.findByUsername(username)
				.orElseThrow(() -> new ResourceNotFoundException("User not found"));
	}

	@Override
	@Transactional
	public User update(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.update(user);
		return user;
	}

	@Override
	@Transactional
	public User create(User user) {
		if(userRepository.findByUsername(user.getUsername()).isPresent()) {
			throw new IllegalStateException("User already exists");
		}
		if(!user.getPassword().equals(user.getPasswordConfirmation())) {
			throw new IllegalStateException("Passwords don't match");
		}
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.create(user);
		Set<Role> roles = Set.of(Role.ROLE_USER);
		userRepository.insertUserRole(user.getId(), Role.ROLE_USER);
		user.setRoles(roles);
		return user;
	}

	@Override
	@Transactional(readOnly = true)
	public boolean isTaskOwner(Long userId, Long taskId) {
		return userRepository.isTaskOwner(userId, taskId);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		userRepository.delete(id);
	}

}
