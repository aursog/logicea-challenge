package com.logicea.challenge.repository;

import com.logicea.challenge.model.StateEntity;
import org.springframework.data.repository.CrudRepository;
import java.util.UUID;

public interface StateRepository extends CrudRepository<StateEntity, UUID> {
}
