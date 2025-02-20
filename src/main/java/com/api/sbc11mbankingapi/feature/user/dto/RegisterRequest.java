package com.api.sbc11mbankingapi.feature.user.dto;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record RegisterRequest(
        @NotBlank(message = "Name is require")
        String name,
        @NotBlank(message = "Gender is require")
        String gender,
        @NotNull(message = "Date of birth is required")
        LocalDate dob,
        @NotBlank(message = "National card Id is required")
        String nationalCardId,
        @NotBlank(message="phone num is requre")
        String phoneNumber,
        @NotBlank(message = "Email is reuired")
        @Email
        String email,
        @NotBlank(message = "Password is required")
        String password,
        @NotBlank(message = "Confirm Password must be match")
        String confirmPassword,
        String pin
) {
}
