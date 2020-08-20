package ru.geekbrains.sample.utils;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.geekbrains.sample.dto.v1.BookDTOV1;
import ru.geekbrains.sample.persistence.entities.Book;

import java.util.List;

@Mapper
public interface BookMapper {

    BookMapper MAPPER = Mappers.getMapper(BookMapper.class);

    Book toBookDTOV1(BookDTOV1 bookDTOV1);

    @InheritInverseConfiguration
    BookDTOV1 fromEntity(Book book);

    List<Book> toBookList(List<BookDTOV1> bookDTOV1s);

}
