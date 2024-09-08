package com.thieunm.messaging_api.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Data
public class BaseResponse<T> {

    private final String time;

    private int code;

    private String message;

    private T data;

    public BaseResponse() {
        this.code = 0;
        this.time = LocalDateTime.now().atZone(ZoneId.systemDefault()).toLocalDateTime().toString();
        this.message = "Success";
    }

    public BaseResponse<T> success(T data) {
        this.code = HttpStatus.OK.value();
        this.data = data;
        return this;
    }
}
