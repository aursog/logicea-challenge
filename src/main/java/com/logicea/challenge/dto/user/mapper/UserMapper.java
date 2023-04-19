package com.logicea.challenge.dto.user.mapper;

import com.logicea.challenge.dto.user.UserDto;
import com.logicea.challenge.enums.UserRole;
import com.logicea.challenge.model.UserEntity;
import com.logicea.challenge.services.user.impl.UserDetailsImpl;
import java.util.UUID;

public class UserMapper {

    public static UserDto toDto(UserEntity userEntity) {
        return userEntity != null ? UserDto.builder()
                .uuid(userEntity.getUuid())
                .username(userEntity.getUsername())
                .role(userEntity.getRole())
                .build() : null;
    }

    public static UserEntity toEntity(UserDto userDto) {
        if (userDto == null) {
            return null;
        }

        UUID uuid = userDto.uuid();
        String username = userDto.username();
        UserRole role = userDto.role();

        return new UserEntity(uuid, username, null, role);
    }

    public static UserDto userDetailsImplToUserDto(UserDetailsImpl userDetails) {
        if (userDetails == null) {
            return null;
        }

        var userDto = UserDto.builder();

        userDto.uuid(userDetails.getUuid());
        userDto.username(userDetails.getUsername());
        userDto.role(UserRole.getValue(userDetails.getAuthorities().get(0).getAuthority()));

        return userDto.build();
    }
}
