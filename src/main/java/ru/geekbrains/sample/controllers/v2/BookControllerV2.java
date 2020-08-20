package ru.geekbrains.sample.controllers.v2;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import ru.geekbrains.sample.dto.v2.BookDTOV2;

import ru.geekbrains.sample.services.BookService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v2/books")
public class BookControllerV2 {

    private final BookService bookService;

    @PostMapping
    public void createOneBook(@RequestBody BookDTOV2 bookDTOV2) {
        bookService.saveOneBookV2(bookDTOV2);
    }

}