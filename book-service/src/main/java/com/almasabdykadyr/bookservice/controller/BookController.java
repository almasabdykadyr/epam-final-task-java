package com.almasabdykadyr.bookservice.controller;

import com.almasabdykadyr.bookservice.dto.BookRequest;
import com.almasabdykadyr.bookservice.dto.BookResponse;
import com.almasabdykadyr.bookservice.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/byId/{id}")
    public ResponseEntity<BookResponse> getBookById(@PathVariable String id) {

        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @PostMapping
    public ResponseEntity<BookResponse> addBook(@RequestBody BookRequest bookRequest) {

        return ResponseEntity.ok(bookService.addBook(bookRequest));
    }

    @GetMapping
    public ResponseEntity<List<BookResponse>> getAll() {

        return ResponseEntity.ok(bookService.getAllBooks());
    }
}
