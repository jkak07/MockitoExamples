package com.jasonk.mockito.testdoubles.stub;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StubTest

{
    @Test
    public void testStub(){
        BookRepository bookRepository = new BookRepositorySub();
      BookService bookService = new BookService(bookRepository);

      List<Book> newBookWithAppliedDiscount = bookService.getNewBooksWithDiscount(10,7);

      Assertions.assertEquals(2,newBookWithAppliedDiscount.size());
    }

    @Test
    public void testStubWithMockito(){
        BookRepository bookRepository = mock(BookRepository.class);
        BookService bookService = new BookService(bookRepository);
        Book book1 = new Book("1234", "learn Mockito", 500, LocalDate.now());
        Book book2 = new Book("1234", "learn Mockito", 400, LocalDate.now());

        //stubbed list//
        List<Book> newBooks = new ArrayList<>();
        newBooks.add(book1);
        newBooks.add(book2);

        when(bookRepository.findNewBooks(7)).thenReturn(newBooks);

        List<Book> newBookWithAppliedDiscount = bookService.getNewBooksWithDiscount(10,7);

        Assertions.assertEquals(2,newBookWithAppliedDiscount.size());
    }
}
