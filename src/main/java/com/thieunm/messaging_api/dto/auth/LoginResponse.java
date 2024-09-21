package com.thieunm.messaging_api.dto.auth;

import lombok.Builder;

@Builder
public record LoginResponse(String accessToken, String refreshToken, long expiresIn, long refreshExpiresIn) {
}
