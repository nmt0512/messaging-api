package com.thieunm.messaging_api.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record RegisterUserRequest(
        @Email String email,
        @NotBlank String password,
        @NotBlank String fullName,
        Boolean gender,
        LocalDate birthday
) {
}
