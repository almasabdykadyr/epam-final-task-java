package com.almasabdykadyr.bookservice.dto;

import com.almasabdykadyr.bookservice.entity.Author;

import java.time.LocalDate;
import java.util.List;

public record BookRequest(String isbn, String title, String description, String language, LocalDate publishAt, List<Author> authors) {
}
