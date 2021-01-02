package com.selendemir.finalproject.model.book;

import com.selendemir.finalproject.model.author.AuthorModel;

import java.io.Serializable;
import java.util.List;

public class BookListModel implements Serializable {

    private static final long serialVersionUID = 280967526831671642L;

    private int id;
    private String name;
    private List<AuthorModel> authors;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AuthorModel> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorModel> authors) {
        this.authors = authors;
    }
}
