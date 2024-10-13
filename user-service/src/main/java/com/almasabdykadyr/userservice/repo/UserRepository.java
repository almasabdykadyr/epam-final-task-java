package com.almasabdykadyr.userservice.repo;


import com.almasabdykadyr.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

//TODO: make migrations via flyway, also add some mock data

public interface UserRepository extends JpaRepository<User, UUID> {
}
