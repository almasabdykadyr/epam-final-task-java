package com.almasabdykadyr.bookservice.repo;

import com.almasabdykadyr.bookservice.entity.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepository extends MongoRepository<Author, String> {
}
