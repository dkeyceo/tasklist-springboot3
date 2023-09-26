package com.dkey.tasklist.web.controllers;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dkey.tasklist.domain.user.User;
import com.dkey.tasklist.service.AuthService;
import com.dkey.tasklist.service.UserService;
import com.dkey.tasklist.web.dto.auth.JwtRequest;
import com.dkey.tasklist.web.dto.auth.JwtResponse;
import com.dkey.tasklist.web.dto.user.UserDto;
import com.dkey.tasklist.web.dto.validation.OnCreate;
import com.dkey.tasklist.web.mappers.UserMapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Validated
public class AuthController {
	
	private final AuthService authService;
	private final UserService userService;
	
	private final UserMapper userMapper;
	
	@PostMapping("/login")
	public JwtResponse login(@Validated @RequestBody JwtRequest jwtRequest) {
		return authService.login(jwtRequest);
	}
	
	@PostMapping("/register")
	public UserDto register(@Validated(OnCreate.class) @RequestBody UserDto userDto) {
		User user = userMapper.toEntity(userDto);
		User createdUser = userService.create(user);
		return userMapper.toDto(createdUser);
	}
	
	@PostMapping("/refresh")
	public JwtResponse refresh(@RequestBody String refreshToken) {
		return authService.refresh(refreshToken);
	}
}
