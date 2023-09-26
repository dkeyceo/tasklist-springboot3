package com.dkey.tasklist.service.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.dkey.tasklist.domain.user.User;
import com.dkey.tasklist.service.AuthService;
import com.dkey.tasklist.service.UserService;
import com.dkey.tasklist.web.dto.auth.JwtRequest;
import com.dkey.tasklist.web.dto.auth.JwtResponse;
import com.dkey.tasklist.web.security.JwtTokenProvider;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{
	
	private final AuthenticationManager authenticationManager;
	private final UserService userService;
	private final JwtTokenProvider jwtTokenProvider;

	@Override
	public JwtResponse login(JwtRequest loginRequest) {
		JwtResponse jwtResponse = new JwtResponse();
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		User user = userService.getByUsername(loginRequest.getUsername());
		jwtResponse.setId(user.getId());
		jwtResponse.setUsername(user.getUsername());
		jwtResponse.setAccessToken(jwtTokenProvider.createAccessToken(user.getId(),user.getUsername(), user.getRoles()));
		jwtResponse.setRefreshToken(jwtTokenProvider.createRefreshToken(user.getId(), user.getUsername()));
		return jwtResponse;
	}

	@Override
	public JwtResponse refresh(String refreshToken) {
		return jwtTokenProvider.refreshUserToken(refreshToken);
	}
	
	
}
 