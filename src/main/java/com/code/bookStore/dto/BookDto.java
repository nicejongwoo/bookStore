package com.code.bookStore.dto;

import com.code.bookStore.model.Book;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BookDto {

    private Long id;
    private String title;
    private String description;
    private int releaseYear;

}
