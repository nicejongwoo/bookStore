package com.code.bookStore.controller;

import com.code.bookStore.dto.BookDto;
import com.code.bookStore.service.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookControllerTest {

    @InjectMocks
    private BookController bookController;

    @Mock
    private BookService bookService;


    @Test
    void shouldReturnBookDtoListWhenGetBooksCalled() {
        List<BookDto> bookDtos = new ArrayList<>();
        BookDto mockBookDto = new BookDto(1L, "test title", "test desc", 2020);
        BookDto mockBookDto2 = new BookDto(2L, "test title2", "test desc2", 2021);
        bookDtos.add(mockBookDto);
        bookDtos.add(mockBookDto2);
        when(bookService.getBooks()).thenReturn(bookDtos);
        ResponseEntity<List<BookDto>> books = bookController.getBooks();
        assertThat(books).isNotNull();
        assertThat(books.getBody().size()).isEqualTo(2);

    }
}