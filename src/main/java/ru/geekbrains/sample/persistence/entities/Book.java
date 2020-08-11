package ru.geekbrains.sample.persistence.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

import java.util.Date;
import java.util.UUID;

@Data
@Entity
public class Book {

    @Id
    public UUID id;

    public String name;

    public Date created;

    public String description;

    public boolean available;

}
