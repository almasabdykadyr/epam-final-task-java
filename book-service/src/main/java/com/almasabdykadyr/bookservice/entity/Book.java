package com.almasabdykadyr.bookservice.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document(collection = "books")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

    @Id
    private String id;

    private String isbn;
    private String title;
    private String description;

    private String language;
    private LocalDate publishAt;

    @DBRef
    private List<Author> authors;
}
