package com.selendemir.finalproject.model.book;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class BookSaveRequestModel implements Serializable {

    private static final long serialVersionUID = 1264112134925232211L;

    private String name;
    private Date publicationDate;
    private String description;
    private List<Integer> authorIds;

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

    public List<Integer> getAuthorIds() {
        return authorIds;
    }

    public void setAuthorIds(List<Integer> authorIds) {
        this.authorIds = authorIds;
    }
}
