package com.dkey.tasklist.service.impl;

import org.springframework.stereotype.Service;

import com.dkey.tasklist.service.AuthService;
import com.dkey.tasklist.web.dto.auth.JwtRequest;
import com.dkey.tasklist.web.dto.auth.JwtResponse;

@Service
public class AuthServiceImpl implements AuthService{

	@Override
	public JwtResponse login(JwtRequest loginRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JwtResponse refresh(String refreshToken) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
 