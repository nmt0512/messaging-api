package com.thieunm.messaging_api.dto.auth;

import lombok.Builder;

@Builder
public record LoginRequest(String email, String password) {
}
