package com.selendemir.finalproject.model.book;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class BookRequestModel implements Serializable {

    private static final long serialVersionUID = 1264112134925232211L;

    private String name;
    private Date publicationDate;
    private String description;
    private List<Integer> authorsIds;

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

    public List<Integer> getAuthorsIds() {
        return authorsIds;
    }

    public void setAuthorsIds(List<Integer> authorsIds) {
        this.authorsIds = authorsIds;
    }
}
