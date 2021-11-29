package com.code.bookStore.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private String title;

    @Column
    @NotNull
    private String description;

    @Column
    @NotNull
    private int releaseYear;
}
