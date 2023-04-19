package com.logicea.challenge.dto.user.mapper;

import com.logicea.challenge.dto.user.UserDto;
import com.logicea.challenge.model.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto toDto(UserEntity userEntity);

    UserEntity toEntity(UserDto userDto);
}
