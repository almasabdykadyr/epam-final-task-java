package com.almasabdykadyr.bookservice.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "authors")
@Data
public class Author {

    private String id;
    private String name;

}
