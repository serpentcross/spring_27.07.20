package ru.geekbrains.sample.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private String name;

    private Date birthDate;
    private boolean graduated;

    @JsonProperty("passport")
    private PassportDTO passportDTO;
}