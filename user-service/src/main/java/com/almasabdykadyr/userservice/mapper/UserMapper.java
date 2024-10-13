package com.almasabdykadyr.userservice.mapper;

import com.almasabdykadyr.userservice.dto.UserResponse;
import com.almasabdykadyr.userservice.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserResponse mapToResponse(User user) {

        return UserResponse.builder()
                .id(user.getId().toString())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .createdAt(user.getCreatedAt())
                .build();
    }
}
