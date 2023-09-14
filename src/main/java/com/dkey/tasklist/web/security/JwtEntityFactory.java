package com.dkey.tasklist.web.security;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.dkey.tasklist.domain.user.Role;
import com.dkey.tasklist.domain.user.User;

public class JwtEntityFactory {
	
	public static JwtEntity create(User user) {
		return new JwtEntity(
				user.getId(), 
				user.getUsername(), 
				user.getName(), 
				user.getPassword(), 
				mapToGrantedAuthorities(new ArrayList<>(user.getRoles())));
	}
	
	public static List<GrantedAuthority> mapToGrantedAuthorities(List<Role> roles){
		return roles.stream()
				.map(Enum::name)
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}
}
