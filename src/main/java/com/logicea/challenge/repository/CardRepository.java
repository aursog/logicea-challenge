package com.logicea.challenge.repository;

import com.logicea.challenge.model.CardEntity;
import org.springframework.data.repository.CrudRepository;
import java.util.UUID;

public interface CardRepository extends CrudRepository<CardEntity, UUID> {
}
