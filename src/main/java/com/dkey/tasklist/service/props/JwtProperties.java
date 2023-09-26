package com.dkey.tasklist.service.props;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
@ConfigurationProperties(prefix = "security.jwt")
public class JwtProperties {
	
	private String secret;
	private long access;
	private long refresh;

}
