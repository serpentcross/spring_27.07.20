package ru.geekbrains.sample.persistence.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.sample.persistence.entities.Library;

import java.util.UUID;

public interface LibraryRepository extends JpaRepository<Library, UUID> {}