package ru.geekbrains.sample.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.geekbrains.sample.persistence.entities.Book;

import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {}