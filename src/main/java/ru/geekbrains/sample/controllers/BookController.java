package ru.geekbrains.sample.controllers;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.geekbrains.sample.dao.BookService;
import ru.geekbrains.sample.dto.BookDTO;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    public void saveOne(BookDTO bookDTO) {
        bookService.save(bookDTO);
    }

}