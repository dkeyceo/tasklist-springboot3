package com.dkey.tasklist.repository;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceUtils;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class DataSourceConfig {
	
	private final DataSource dataSource;
	
	public Connection getConnection() {
		return DataSourceUtils.getConnection(dataSource);
	}
}
