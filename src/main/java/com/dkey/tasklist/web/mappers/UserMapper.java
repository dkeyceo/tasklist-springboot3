package com.dkey.tasklist.web.mappers;

import org.mapstruct.Mapper;

import com.dkey.tasklist.domain.user.User;
import com.dkey.tasklist.web.dto.user.UserDto;

@Mapper(componentModel = "spring")
public interface UserMapper {
	
	UserDto toDto(User user);
	
	User toEntity(UserDto userDto);

}
