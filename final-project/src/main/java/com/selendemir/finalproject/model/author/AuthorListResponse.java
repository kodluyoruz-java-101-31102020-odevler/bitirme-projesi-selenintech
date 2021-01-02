package com.selendemir.finalproject.model.author;

import java.io.Serializable;
import java.util.List;

public class AuthorListResponse implements Serializable {

    private static final long serialVersionUID = 6123718770062412226L;

    private List<AuthorModel> authors;

    public List<AuthorModel> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorModel> authors) {
        this.authors = authors;
    }
}
