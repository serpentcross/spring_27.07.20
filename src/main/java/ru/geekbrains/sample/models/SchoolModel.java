package ru.geekbrains.sample.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchoolModel {
    private String schoolName;
    private String libraryName;
    private String principalName;
    private String birthDate;
}