package ru.geekbrains.sample.dao;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import ru.geekbrains.sample.dto.BookDTO;
import ru.geekbrains.sample.persistence.entity.Book;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public void save(BookDTO bookDTO) {
        bookRepository.save(
            Book.builder()
                .name(bookDTO.getName())
                .available(bookDTO.isAvailable())
                .created(new Date())
            .build()
        );
    }

}
