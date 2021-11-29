package com.code.bookStore.service;

import com.code.bookStore.dto.BookDto;
import com.code.bookStore.model.Book;
import com.code.bookStore.repository.BookRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

//    @Mock
//    private ModelMapper modelMapper;

    @Test
    void shouldReturnListOfBookDtoWhenGetBooksCalled() {
        Book mockBook = new Book(1L, "test title", "test desc", 2020);
        List<Book> books = new ArrayList<>();
        books.add(mockBook);

        when(bookRepository.findAll()).thenReturn(books);

        List<BookDto> bookDtos = bookService.getBooks();

        assertThat(bookDtos.get(0))
                .isNotNull()
                .hasFieldOrPropertyWithValue("title", "test title")
                .hasFieldOrPropertyWithValue("description", "test desc")
                .hasFieldOrPropertyWithValue("releaseYear", 2020);

    }

}