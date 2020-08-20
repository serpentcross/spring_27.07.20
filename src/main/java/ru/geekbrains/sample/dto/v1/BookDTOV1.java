package ru.geekbrains.sample.dto.v1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDTOV1 {
    private String name;
    private String description;
    private Date created;
    private boolean available;
}