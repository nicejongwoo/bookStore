package com.code.bookStore.repository;

import com.code.bookStore.model.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void shouldAbleToFetchAllBooksInDB(){
        List<Book> all = bookRepository.findAll();
        long totalBookCount = StreamSupport.stream(all.spliterator(), false).count();
        Assertions.assertEquals(totalBookCount, 1);
    }
    @Test
    void shouldReturnOneBookWithTitleIsTestTitle1(){
        List<Book> book = bookRepository.findBooksByTitle("test title");
        Assertions.assertEquals(book.size(), 1);
    }

}