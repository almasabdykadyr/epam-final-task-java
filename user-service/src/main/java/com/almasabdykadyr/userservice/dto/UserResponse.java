package com.almasabdykadyr.userservice.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record UserResponse(String id, String email, String firstName, String lastName, LocalDateTime createdAt) {
}
