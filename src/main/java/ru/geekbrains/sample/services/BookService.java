package ru.geekbrains.sample.services;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import ru.geekbrains.sample.dto.v1.BookDTOV1;
import ru.geekbrains.sample.dto.v2.BookDTOV2;
import ru.geekbrains.sample.persistence.entities.Book;
import ru.geekbrains.sample.persistence.repositories.BookRepository;
import ru.geekbrains.sample.persistence.repositories.SchoolRepository;
import ru.geekbrains.sample.utils.Converter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookService {

    private final Converter converter;

    private final BookRepository bookRepository;

    private final SchoolRepository schoolRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getOne(UUID id) {
        return bookRepository.findById(id).orElse(null);
    }

    public void saveOneBookV1(BookDTOV1 bookDTOV1) {
       bookRepository.save(converter.convertDtoToEntity(bookDTOV1));
    }

    public void saveOneBookV2(BookDTOV2 bookDTOV2) {
        bookRepository.save(Book.builder()
                .available(bookDTOV2.isAvailable())
                .created(new Date())
                .description(bookDTOV2.getDescription())
                .name(bookDTOV2.getName())
                .author(bookDTOV2.getAuthor())
        .build());
    }

}