package com.almasabdykadyr.bookservice.dto;

import com.almasabdykadyr.bookservice.entity.Author;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record BookResponse (String id, String isbn, String title, String description, String language, LocalDate publishAt, List<Author> authors) {
}
