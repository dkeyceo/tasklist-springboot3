package com.dkey.tasklist.repository.mappers;

import java.sql.ResultSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.dkey.tasklist.domain.task.Task;
import com.dkey.tasklist.domain.user.Role;
import com.dkey.tasklist.domain.user.User;

import lombok.SneakyThrows;

public class UserRowMapper {

	@SneakyThrows
	public static User mapRow(ResultSet rs) {
		Set<Role> roles = new HashSet();
		while (rs.next()) {
			roles.add(Role.valueOf(rs.getString("user_role_role")));
		}
		rs.beforeFirst();
		List<Task> tasks = TaskRowMapper.mapRows(rs);
		rs.beforeFirst();
		if(rs.next()) {
			User user = new User();
			user.setId(rs.getLong("user_id"));
			user.setName(rs.getString("user_name"));
			user.setUsername(rs.getString("user_username"));
			user.setPassword(rs.getString("user_password"));
			user.setRoles(roles);
			user.setTasks(tasks);
			return user;
		}
		return null;
	}
}
