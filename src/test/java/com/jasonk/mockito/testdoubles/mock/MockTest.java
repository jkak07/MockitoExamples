package com.jasonk.mockito.testdoubles.mock;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

public class MockTest {

    @Test
    public void demoMock(){
        BookRepositoryMock bookRepositoryMock = new BookRepositoryMock();
        BookService bookService = new BookService(bookRepositoryMock);

        Book book1 = new Book("12345","Mockito is a good name", 500, LocalDate.now());
        Book book2 = new Book("12345","Mockito is a great name", 400, LocalDate.now());

        bookService.addBook(book1);
        bookService.addBook(book2);

        bookRepositoryMock.verify(book2,1);

        //recording not done by mock in spy, asserts made at test level, in mocks in this example it had the job to do so
       /* bookService.addBook(book1);
        Assertions.assertEquals(0, bookRepositoryMock.timesCalled());

        bookService.addBook(book1);
        Assertions.assertEquals(1, bookRepositoryMock.timesCalled());*/
    }

    @Test
    public void demoMockWithMockito(){
        BookRepository bookRepositoryMock = Mockito.mock(BookRepository.class);
        BookService bookService = new BookService(bookRepositoryMock);

        Book book1 = new Book("12345","Mockito is a good name", 500, LocalDate.now());
        Book book2 = new Book("12345","Mockito is a great name", 400, LocalDate.now());

        bookService.addBook(book1);
        bookService.addBook(book2);

        Mockito.verify(bookRepositoryMock, Mockito.times(0)).save(book1);
        Mockito.verify(bookRepositoryMock, Mockito.times(1)).save(book2);
    }
}
