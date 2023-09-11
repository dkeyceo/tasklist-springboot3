package com.dkey.tasklist.web.dto.task;

import java.time.LocalDateTime;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import com.dkey.tasklist.domain.task.Status;
import com.dkey.tasklist.web.dto.validation.OnCreate;
import com.dkey.tasklist.web.dto.validation.OnUpdate;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TaskDto {
	
	@NotNull(message="Id must be not null", groups = {OnUpdate.class})
	private Long id;
	
	@NotNull(message="Title must be not null", groups = {OnCreate.class, OnUpdate.class})
	@Length(max = 255, message="Title length must be not more than 255 symbols", groups = {OnCreate.class, OnUpdate.class})
	private String title;
	
	@Length(max = 255, message="Description length must be not more than 255 symbols", groups = {OnCreate.class, OnUpdate.class})
	private String description;
	
	private Status status;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime expirationDate;
}
