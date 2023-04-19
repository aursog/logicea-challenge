package com.logicea.challenge.dto.cards;

import com.sun.istack.NotNull;

public record CardRequestDto(
        @NotNull
        String name,
        String color,
        String description
) {
}
