package ru.geekbrains.sample.dao;

import org.springframework.stereotype.Repository;

import ru.geekbrains.sample.persistence.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import java.util.List;

@Repository
public class BookRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Book> findAllBooks() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);
        Root<Book> root = criteriaQuery.from(Book.class);
        CriteriaQuery<Book> all = criteriaQuery.select(root);
        return entityManager.createQuery(all).getResultList();
    }
}
