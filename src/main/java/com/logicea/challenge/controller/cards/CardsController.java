package com.logicea.challenge.controller.cards;

import com.logicea.challenge.dto.cards.CardDto;
import com.logicea.challenge.dto.cards.CardRequestDto;
import com.logicea.challenge.exceptions.NotFoundRecordException;
import com.logicea.challenge.services.cards.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;

@RestController
@RequestMapping("/api/cards")
public class CardsController {

    private CardService cardService;

    @Autowired
    public CardsController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping
    public Page<CardDto> showByPage(
            @RequestParam(value = "page", required = false) Pageable pageable,
            @RequestParam(value = "sort", required = false) Sort sort
    ) {

        PageRequest pageRequest = PageRequest.of(0, Integer.MAX_VALUE, Sort.by(Sort.Direction.ASC, "createdAt"));

        if (pageable != null && sort != null) {
            pageRequest = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);
        } else if (pageable != null && sort == null) {
            pageRequest = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by(Sort.Direction.ASC, "createdAt"));
        }

        return cardService.findAll(pageRequest);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<CardDto> findByUuid(
            @PathVariable final UUID uuid
    ) throws NotFoundRecordException {
        return ResponseEntity.ok().body(cardService.findByUuid(uuid));
    }

    @PostMapping
    public ResponseEntity<CardDto> saveCard(
            @RequestBody final CardRequestDto cardRequest
    ) {
        return ResponseEntity.ok().body(cardService.save(cardRequest));
    }
}
