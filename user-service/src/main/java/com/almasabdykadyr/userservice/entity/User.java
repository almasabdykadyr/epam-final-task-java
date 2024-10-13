package com.almasabdykadyr.userservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @UuidGenerator
    private UUID id;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Role role;
    private LocalDateTime createdAt;
}
