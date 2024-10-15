package com.almasabdykadyr.bookservice.service;

import com.almasabdykadyr.bookservice.repo.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

//TODO: use AuthorService, use joins

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;
}
