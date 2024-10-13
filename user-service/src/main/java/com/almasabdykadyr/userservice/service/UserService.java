package com.almasabdykadyr.userservice.service;

import com.almasabdykadyr.userservice.entity.Role;
import com.almasabdykadyr.userservice.mapper.UserMapper;
import com.almasabdykadyr.userservice.dto.UserRequest;
import com.almasabdykadyr.userservice.dto.UserResponse;
import com.almasabdykadyr.userservice.dto.UserUpdateRequest;
import com.almasabdykadyr.userservice.entity.User;
import com.almasabdykadyr.userservice.producer.EventProducer;
import com.almasabdykadyr.userservice.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final EventProducer eventProducer;
    private final UserMapper mapper;

    public UserResponse saveUser(UserRequest userRequest) {

        User user = userRepository.save(
                User.builder()
                        .email(userRequest.email())
                        .password(userRequest.password())
                        .firstName(userRequest.firstName())
                        .lastName(userRequest.lastName())
                        .role(Role.USER)
                        .createdAt(LocalDateTime.now())
                    .build()
        );

        eventProducer.sendEvent(user);

        return mapper.mapToResponse(user);
    }

    public UserResponse getUserById(String id) {

        User user = userRepository.findById(UUID.fromString(id)).orElseThrow(RuntimeException::new);

        return mapper.mapToResponse(user);
    }

    public UserResponse updateUserById(String id, UserUpdateRequest request) {

        User foundUser = userRepository.findById(UUID.fromString(id)).orElseThrow(RuntimeException::new);

        if (request.email() != null) {

            foundUser.setEmail(request.email());
        }
        if (request.password() != null) {

            foundUser.setPassword(request.password());
        }
        if (request.firstName() != null) {

            foundUser.setFirstName(request.firstName());
        }
        if (request.lastName() != null) {

            foundUser.setLastName(request.lastName());
        }
        if (request.role() != null) {

            foundUser.setRole(request.role());
        }

        return mapper.mapToResponse(foundUser);
    }

    public void deleteUserById(String id) {

        userRepository.deleteById(UUID.fromString(id));
    }
}
