package com.logicea.challenge.services.cards;

import com.logicea.challenge.dto.cards.CardDto;
import com.logicea.challenge.dto.cards.CardRequestDto;
import com.logicea.challenge.exceptions.NotFoundRecordException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.UUID;

public interface CardService {

    Page<CardDto> findAll(Pageable page);

    CardDto findByUuid(UUID uuid) throws NotFoundRecordException;

    CardDto save(CardRequestDto cardRequestDto);

}
