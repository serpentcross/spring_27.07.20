package ru.geekbrains.sample.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.geekbrains.sample.persistence.entities.Principal;

import java.util.UUID;

public interface PrincipalRepository extends JpaRepository<Principal, UUID> {}