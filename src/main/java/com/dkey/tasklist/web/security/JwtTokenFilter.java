package com.dkey.tasklist.web.security;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import com.dkey.tasklist.domain.exception.ResourceNotFoundException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JwtTokenFilter extends GenericFilterBean {

	private final JwtTokenProvider jwtTokenProvider;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String bearerToken = ((HttpServletRequest) request).getHeader("Authorization");
		if(bearerToken != null && bearerToken.startsWith("Bearer ")) {
			bearerToken = bearerToken.substring(7);
		}
		if(bearerToken != null && jwtTokenProvider.validateToken(bearerToken)) {
			try {
				Authentication authentication = jwtTokenProvider.getAuthentication(bearerToken);
				if(authentication != null) {
					SecurityContextHolder.getContext().setAuthentication(authentication);
				}
			}catch (ResourceNotFoundException ignored) {
				
			}
		}
		chain.doFilter(request, response);
	}

}
