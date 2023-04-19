package com.logicea.challenge.dto.user;

import com.logicea.challenge.enums.UserRole;
import java.util.UUID;

public record UserDto (
        UUID uuid,
        String username,
        UserRole role
) { }
