package com.hyvercode.spring.model.request;


import java.io.Serializable;

public class BookRequest implements Serializable {
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    private int bookId;
    private String bookName;

    public BookRequest(int bookId, String bookName) {
        this.bookId = bookId;
        this.bookName = bookName;
    }
}
