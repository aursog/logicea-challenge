package com.logicea.challenge.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Table(name = "tbl_state")
@Entity
@DynamicUpdate
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StateEntity {
    @Id
    private UUID uuid;
    @Column
    private String name;
}
