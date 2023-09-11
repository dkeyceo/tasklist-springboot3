package com.dkey.tasklist.service;

import com.dkey.tasklist.web.dto.auth.JwtRequest;
import com.dkey.tasklist.web.dto.auth.JwtResponse;

public interface AuthService {
	
	JwtResponse login(JwtRequest loginRequest);
	
	JwtResponse refresh(String refreshToken);
}
