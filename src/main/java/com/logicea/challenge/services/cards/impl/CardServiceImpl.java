package com.logicea.challenge.services.cards.impl;

import com.logicea.challenge.dto.cards.CardDto;
import com.logicea.challenge.dto.cards.CardRequestDto;
import com.logicea.challenge.dto.cards.mapper.CardMapper;
import com.logicea.challenge.dto.user.mapper.UserMapper;
import com.logicea.challenge.enums.CardState;
import com.logicea.challenge.enums.UserRole;
import com.logicea.challenge.exceptions.NotFoundRecordException;
import com.logicea.challenge.repository.CardRepository;
import com.logicea.challenge.services.cards.CardService;
import com.logicea.challenge.services.user.impl.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CardServiceImpl implements CardService {

    private CardRepository cardRepository;

    @Autowired
    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public Page<CardDto> findAll(Pageable page) {
        UserDetailsImpl user = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return new PageImpl<>(StreamSupport.stream(cardRepository.findAll(page).spliterator(), true)
                        .filter(entity -> user.getAuthorities().get(0).getAuthority().contains(UserRole.member.toString()) ? entity.getUser().getUsername().equals(user.getUsername()) : true)
                        .map(CardMapper::toDto)
                        .collect(Collectors.toList()));
    }

    @Override
    public CardDto findByUuid(UUID uuid) throws NotFoundRecordException {
        UserDetailsImpl user = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return cardRepository.findById(uuid)
                .filter(entity -> user.getAuthorities().get(0).getAuthority().contains(UserRole.member.toString()) ? entity.getUser().getUsername().equals(user.getUsername()) : true)
                .map(CardMapper::toDto)
                .orElseThrow(() -> new NotFoundRecordException("Card with uuid -> ${uuid} not found"));
    }

    @Override
    public CardDto save(CardRequestDto cardRequestDto) {
        UserDetailsImpl user = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        CardDto cardDto = CardDto.builder()
                .name(cardRequestDto.name())
                .description(cardRequestDto.description())
                .color(cardRequestDto.color())
                .state(CardState.ToDo)
                .userDto(UserMapper.userDetailsImplToUserDto(user))
                .build();

        return CardMapper.toDto(cardRepository.save(CardMapper.toEntity(cardDto)));
    }
}
