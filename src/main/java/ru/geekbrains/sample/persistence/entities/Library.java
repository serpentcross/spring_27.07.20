package ru.geekbrains.sample.persistence.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Data
@Entity
public class Library extends AbstractPersistableEntity {

    private String name;

    private boolean open;

    @ManyToOne
    @JoinColumn(name = "school")
    private School school;

    @Transient
    private int index;
}