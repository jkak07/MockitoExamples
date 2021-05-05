package com.jasonk.mockito.testdoubles.mock;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookRepositoryMock implements BookRepository {

    int saveCalled = 0;
    Book lastAddedBook = null;

    @Override
    public void save(Book book){
        saveCalled++;
        lastAddedBook = book;
    }
    //for mocks the behaviour is tested by the mock not directly hardcoded in test
    public void verify(Book book, int times){
        assertEquals(times, saveCalled);
        assertEquals(book, lastAddedBook);
    }

   /* public int timesCalled(){
        return saveCalled;
    }

    public boolean calledWith(Book book){
        return lastAddedBook.equals(book);
    }*/


}
