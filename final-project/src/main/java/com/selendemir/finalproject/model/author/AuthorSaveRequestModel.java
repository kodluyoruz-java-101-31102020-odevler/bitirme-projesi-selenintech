package com.selendemir.finalproject.model.author;

import java.io.Serializable;

public class AuthorSaveRequestModel implements Serializable {

    private static final long serialVersionUID = -1038056406603917548L;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
