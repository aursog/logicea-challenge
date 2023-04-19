package com.logicea.challenge.model;

import com.logicea.challenge.enums.CardState;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "tbl_card")
@Entity
@DynamicUpdate
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CardEntity {
    @Id
    @GeneratedValue
    private UUID uuid;
    @Column
    private String name;
    @Column(columnDefinition = "text")
    private String description;
    @Column
    private String color;
    @Column(name = "card_state")
    @Enumerated(EnumType.STRING)
    private CardState state;
    @ManyToOne
    @JoinColumn(name = "user_uuid")
    private UserEntity user;
    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
