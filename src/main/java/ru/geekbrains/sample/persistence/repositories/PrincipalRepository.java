package ru.geekbrains.sample.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.geekbrains.sample.persistence.entities.Director;

import java.util.UUID;

public interface PrincipalRepository extends JpaRepository<Director, UUID> {}