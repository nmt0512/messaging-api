package com.thieunm.messaging_api.enums;

import lombok.Getter;

@Getter
public enum RolesEnum {
    ADMIN(0, "ROLE_ADMIN"),
    USER(1, "ROLE_USER");

    private final int code;
    private final String name;

    RolesEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }
}
