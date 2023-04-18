package com.logicea.challenge.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "tbl_state")
@Entity
@DynamicUpdate
@Getter
@AllArgsConstructor
public class StateEntity extends Base {

    @Column
    private String name;
}
