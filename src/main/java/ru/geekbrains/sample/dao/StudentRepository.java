package ru.geekbrains.sample.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ru.geekbrains.sample.dto.StudentDTO;
import ru.geekbrains.sample.persistence.entity.Passport;
import ru.geekbrains.sample.persistence.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class StudentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Student> findAllStudents() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
        Root<Student> root = criteriaQuery.from(Student.class);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(criteriaBuilder.equal(root.get("graduated"), false));
        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[]{})));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Transactional
    public void save(StudentDTO studentDTO) {
        Passport passport = Passport.builder().name(studentDTO.getPassportDTO().getName()).build();
        entityManager.persist(passport);
        Student student = Student.builder()
            .name(studentDTO.getName())
            .birthDate(new Date())
            .graduated(studentDTO.isGraduated())
            .passport(passport)
            .build();
        entityManager.persist(student);
    }

    //SELECT * FROM student WHERE graduated IS false;

}