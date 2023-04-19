package com.logicea.challenge.repository;

import com.logicea.challenge.model.UserEntity;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends CrudRepository<UserEntity, UUID> {

    Optional<UserEntity> findByUsername(String username);
}
