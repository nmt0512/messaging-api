package com.thieunm.messaging_api.enums;

import lombok.Getter;

@Getter
public enum StatusEnum {
    OFFLINE(0, "offline"),
    ONLINE(1, "online");

    private final int code;
    private final String name;

    StatusEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }
}
