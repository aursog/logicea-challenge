package com.logicea.challenge.dto.cards;

import com.logicea.challenge.dto.user.UserDto;
import com.logicea.challenge.enums.CardState;
import lombok.Builder;
import java.util.UUID;

@Builder
public record CardDto (
        UUID uuid,
        String name,
        String description,
        String color,
        CardState state,
        UserDto userDto
) { }
