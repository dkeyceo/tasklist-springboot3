package com.dkey.tasklist.domain.user;

import java.util.List;
import java.util.Set;

import com.dkey.tasklist.domain.task.Task;

import lombok.Data;

@Data
public class User {
	private Long id;
	private String name;
	private String username;
	private String password;
	private String passwordConfirmation;
	private Set<Role> roles;
	private List<Task> tasks;
}
