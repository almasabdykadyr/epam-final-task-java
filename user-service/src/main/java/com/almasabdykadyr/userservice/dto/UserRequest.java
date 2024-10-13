package com.almasabdykadyr.userservice.dto;


public record UserRequest(String email, String password, String firstName, String lastName) {
}
