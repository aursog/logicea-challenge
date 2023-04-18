package com.logicea.challenge.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Table(name = "tbl_card")
@Entity
@DynamicUpdate
@Getter
@AllArgsConstructor
public class CardEntity extends Base {

    @Column
    private String name;
    @Column
    private String description;
    @Column
    private String color;
    @ManyToOne
    @JoinColumn(name = "state_uuid")
    private StateEntity state;
    @ManyToOne
    @JoinColumn(name = "user_uuid")
    private UserEntity user;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
