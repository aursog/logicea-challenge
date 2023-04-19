package com.logicea.challenge.dto.user;

import com.logicea.challenge.enums.UserRole;
import lombok.Builder;
import java.util.UUID;

@Builder
public record UserDto (
        UUID uuid,
        String username,
        UserRole role
) { }
