package com.logicea.challenge.model;

import com.logicea.challenge.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Table(name = "tbl_user")
@Entity
@DynamicUpdate
@Getter
@AllArgsConstructor
public class UserEntity extends Base {

    @Column
    private String username;

    @Column
    private String passwd;

    @Column
    @Enumerated(EnumType.STRING)
    private UserRole role;

}
