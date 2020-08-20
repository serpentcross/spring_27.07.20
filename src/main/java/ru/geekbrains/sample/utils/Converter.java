package ru.geekbrains.sample.utils;

import org.springframework.stereotype.Component;
import ru.geekbrains.sample.dto.v1.BookDTOV1;
import ru.geekbrains.sample.persistence.entities.Book;

import java.util.Date;

@Component
public class Converter {

    public Book convertDtoToEntity(BookDTOV1 bookDTOV1) {
        return Book.builder()
                .available(bookDTOV1.isAvailable())
                .created(new Date())
                .description(bookDTOV1.getDescription())
                .name(bookDTOV1.getName()).build();
    }


}
