package com.almasabdykadyr.userservice.dto;

import com.almasabdykadyr.userservice.entity.Role;
import com.fasterxml.jackson.annotation.JsonProperty;

public record UserUpdateRequest(
        @JsonProperty String email,
        @JsonProperty String password,
        @JsonProperty String firstName,
        @JsonProperty String lastName,
        @JsonProperty Role role
) {
}
