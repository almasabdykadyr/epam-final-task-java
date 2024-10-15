package com.almasabdykadyr.bookservice.repo;


import com.almasabdykadyr.bookservice.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {
}
