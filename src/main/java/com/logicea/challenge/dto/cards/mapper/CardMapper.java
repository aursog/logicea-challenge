package com.logicea.challenge.dto.cards.mapper;

import com.logicea.challenge.dto.cards.CardDto;
import com.logicea.challenge.dto.user.mapper.UserMapper;
import com.logicea.challenge.enums.CardState;
import com.logicea.challenge.model.CardEntity;
import com.logicea.challenge.model.UserEntity;
import java.util.UUID;

public class CardMapper {

    public static CardDto toDto(CardEntity entity) {
        return entity != null ? CardDto.builder()
                .uuid(entity.getUuid())
                .name(entity.getName())
                .description(entity.getDescription())
                .color(entity.getColor())
                .state(entity.getState())
                .userDto(UserMapper.toDto(entity.getUser()))
                .build() : null;
    }

    public static CardEntity toEntity(CardDto dto) {
        if (dto == null) {
            return null;
        }

        UUID uuid = dto.uuid();
        String name = dto.name();
        String description = dto.description();
        String color = dto.color();
        CardState state = dto.state();
        UserEntity user = UserMapper.toEntity(dto.userDto());

        return new CardEntity(uuid, name, description, color, state, user, null, null);
    }
}
