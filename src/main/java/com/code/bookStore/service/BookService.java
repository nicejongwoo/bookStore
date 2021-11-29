package com.code.bookStore.service;

import com.code.bookStore.dto.BookDto;
import com.code.bookStore.model.Book;
import com.code.bookStore.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;
    private ModelMapper modelMapper = new ModelMapper();

    public List<BookDto> getBooks() {
        List<Book> all = bookRepository.findAll();

        return all.stream().map(book -> modelMapper.map(book, BookDto.class))
                .collect(Collectors.toList());
    }


}
