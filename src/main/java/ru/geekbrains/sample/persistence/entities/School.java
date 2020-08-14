package ru.geekbrains.sample.persistence.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Transient;

@Data
@Entity
public class School extends AbstractPersistableEntity {

    private String name;
    private boolean open;

    @Transient
    private String number;

}