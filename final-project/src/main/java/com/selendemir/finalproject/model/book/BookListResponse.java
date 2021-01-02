package com.selendemir.finalproject.model.book;

import java.io.Serializable;
import java.util.List;

public class BookListResponse implements Serializable {

    private static final long serialVersionUID = -5513322513191209316L;

    private List<BookListModel> books;

    public List<BookListModel> getBooks() {
        return books;
    }

    public void setBooks(List<BookListModel> books) {
        this.books = books;
    }
}
