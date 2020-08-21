package ru.geekbrains.sample.persistence.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Director extends AbstractPersistableEntity {

    private String firstName;
    private String birthDate;

    @ManyToOne
    @JoinColumn(name = "library")
    private Library library;

}