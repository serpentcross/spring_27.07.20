package ru.geekbrains.sample.persistence.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.util.Date;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Book extends AbstractEntity {

    private String name;
    private Date created;
    private String description;
    private boolean available;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student")
    private Student student;

}