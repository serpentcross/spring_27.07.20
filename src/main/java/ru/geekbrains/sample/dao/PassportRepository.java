package ru.geekbrains.sample.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ru.geekbrains.sample.dto.PassportDTO;
import ru.geekbrains.sample.persistence.entity.Passport;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PassportRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(PassportDTO passportDTO) {
        Passport passport = Passport.builder().name(passportDTO.getName()).build();
        entityManager.persist(passport);
    }

}