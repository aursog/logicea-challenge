package com.logicea.challenge.enums;

public enum UserRole {
    admin,
    member;

    public static UserRole getValue(String role) {
        return UserRole.valueOf(role);
    }
}
