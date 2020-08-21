package ru.geekbrains.sample.services;

import org.springframework.stereotype.Service;

import ru.geekbrains.sample.models.SchoolModel;
import ru.geekbrains.sample.persistence.entities.Director;
import ru.geekbrains.sample.persistence.entities.Library;
import ru.geekbrains.sample.persistence.entities.School;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import java.util.List;
import java.util.UUID;

@Service
public class SchoolService {

    @PersistenceContext
    private EntityManager entityManager;

    public List<School> getAllSchoolsByPrincipal(String principalName) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<School> criteriaQuery = criteriaBuilder.createQuery(School.class);

        Root<Director> root = criteriaQuery.from(Director.class);
        Join<Director, Library> principalLibraryJoin = root.join("library");
        Join<Library, School> librarySchoolJoin = principalLibraryJoin.join("school");

        Predicate predicatePrincipalName = criteriaBuilder.equal(root.get("firstName"), principalName);
        Predicate predicateLibraryOpen = criteriaBuilder.equal(principalLibraryJoin.get("open"), true);

        criteriaQuery.where(criteriaBuilder.and(predicatePrincipalName, predicateLibraryOpen));
        criteriaQuery.select(librarySchoolJoin);

        return entityManager.createQuery(criteriaQuery).getResultList();

    }

    public List<SchoolModel> getAllSchoolModels(UUID id) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<SchoolModel> criteriaQuery = criteriaBuilder.createQuery(SchoolModel.class);

        Root<Director> root = criteriaQuery.from(Director.class);
        Join<Director, Library> principalLibraryJoin = root.join("library");
        Join<Library, School> librarySchoolJoin = principalLibraryJoin.join("school");

        criteriaQuery.multiselect(librarySchoolJoin.get("name"), principalLibraryJoin.get("name"), root.get("firstName"), root.get("birthDate"))
        .where(criteriaBuilder.and(criteriaBuilder.equal(librarySchoolJoin.get("id"), id)));

        List<SchoolModel> schoolModels = entityManager.createQuery(criteriaQuery).getResultList();

        return schoolModels;

    }

}