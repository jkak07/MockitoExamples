package com.jasonk.mockito.testdoubles.fake;



import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class FakeBookRepository implements BookRepository {

    //use in memory database, hashmap or List
    Map<String, Book> bookStore = new HashMap<>();

    @Override
    public void save(Book book) {
        bookStore.put(book.getBookID(),book);
    }

    @Override
    public Collection<Book> findAll() {
        return bookStore.values();
    }
}
