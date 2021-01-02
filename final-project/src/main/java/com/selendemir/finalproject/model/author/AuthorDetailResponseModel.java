package com.selendemir.finalproject.model.author;

import com.selendemir.finalproject.model.book.BookListModel;

import java.io.Serializable;
import java.util.List;

public class AuthorDetailResponseModel implements Serializable {

    private static final long serialVersionUID = -1015887530649686544L;

    private AuthorModel author;
    private List<BookListModel> books;

    public AuthorModel getAuthor() {
        return author;
    }

    public void setAuthor(AuthorModel author) {
        this.author = author;
    }

    public List<BookListModel> getBooks() {
        return books;
    }

    public void setBooks(List<BookListModel> books) {
        this.books = books;
    }
}
