package com.thieunm.messaging_api.utils;

import com.thieunm.messaging_api.dto.BaseResponse;
import org.springframework.http.ResponseEntity;

public class ResponseUtils {

    private ResponseUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static <T> ResponseEntity<BaseResponse<T>> success(T data) {
        return ResponseEntity.ok(new BaseResponse<T>().success(data));
    }
}
