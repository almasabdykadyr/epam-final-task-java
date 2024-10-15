package com.almasabdykadyr.bookservice.service;

import com.almasabdykadyr.bookservice.dto.BookRequest;
import com.almasabdykadyr.bookservice.dto.BookResponse;
import com.almasabdykadyr.bookservice.entity.Book;
import com.almasabdykadyr.bookservice.repo.AuthorRepository;
import com.almasabdykadyr.bookservice.repo.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookResponse getBookById(String id) {

        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("error while finding book with given id"));

        return BookResponse.builder()
                .id(book.getId())
                .isbn(book.getIsbn())
                .title(book.getTitle())
                .description(book.getDescription())
                .language(book.getLanguage())
                .publishAt(book.getPublishAt())
                .authors(book.getAuthors())
                .build();
    }

    public BookResponse addBook(BookRequest bookRequest) {

        Book book = bookRepository.insert(Book.builder()
                .isbn(bookRequest.isbn())
                .title(bookRequest.title())
                .description(bookRequest.description())
                .language(bookRequest.language())
                .publishAt(bookRequest.publishAt())
                .authors(bookRequest.authors())
                .build());

        return BookResponse.builder()
                .id(book.getId())
                .isbn(book.getIsbn())
                .title(book.getTitle())
                .description(book.getDescription())
                .language(book.getLanguage())
                .publishAt(book.getPublishAt())
                .authors(book.getAuthors())
                .build();
    }


    public List<BookResponse> getAllBooks() {

        return bookRepository.findAll().stream().map(book -> BookResponse.builder()
                .id(book.getId())
                .isbn(book.getIsbn())
                .title(book.getTitle())
                .description(book.getDescription())
                .language(book.getLanguage())
                .publishAt(book.getPublishAt())
                .authors(book.getAuthors())
                .build()).collect(Collectors.toList());
    }
}
