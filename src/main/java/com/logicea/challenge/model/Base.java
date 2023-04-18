package com.logicea.challenge.model;

import javax.persistence.Id;
import java.util.UUID;

public abstract class Base {

    @Id
    private UUID uuid;
}
