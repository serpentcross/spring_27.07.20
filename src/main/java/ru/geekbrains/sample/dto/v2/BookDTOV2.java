package ru.geekbrains.sample.dto.v2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDTOV2 {
    private String name;
    private String description;
    private Date created;
    private boolean available;
    private String author;
}