package com.hyvercode.spring.model.response;


import java.io.Serializable;

public class BookResponse implements Serializable {
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

    public BookResponse(int bookId, String bookName) {
        this.bookId = bookId;
        this.bookName = bookName;
    }
}
