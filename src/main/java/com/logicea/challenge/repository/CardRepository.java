package com.logicea.challenge.repository;

import com.logicea.challenge.model.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface CardRepository extends JpaRepository<CardEntity, UUID> {
}
