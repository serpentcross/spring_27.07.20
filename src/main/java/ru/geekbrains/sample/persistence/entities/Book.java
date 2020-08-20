package ru.geekbrains.sample.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    public UUID id;

    public String name;

    public Date created;

    public String description;

    public boolean available;

    public String author;

}