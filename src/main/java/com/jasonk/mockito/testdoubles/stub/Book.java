package com.jasonk.mockito.testdoubles.stub;

import java.time.LocalDate;

public class Book {

    private String bookID;
    private String title;
    private int price;
    private LocalDate publishedDate;

    public Book(String bookID, String title, int price, LocalDate publishedDate) {
        this.bookID = bookID;
        this.title = title;
        this.price = price;
        this.publishedDate = publishedDate;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }
}

