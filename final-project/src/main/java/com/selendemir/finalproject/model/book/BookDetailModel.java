package com.selendemir.finalproject.model.book;

import com.selendemir.finalproject.model.author.AuthorModel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class BookDetailModel implements Serializable {

    private static final long serialVersionUID = -7015239682475387303L;

    private int id;
    private String name;
    private Date publicationDate;
    private String description;
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

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<AuthorModel> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorModel> authors) {
        this.authors = authors;
    }
}
