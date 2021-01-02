package com.selendemir.finalproject.model;

import java.io.Serializable;

public class Author implements Serializable {


    private static final long serialVersionUID = 2856920642472022137L;

    private int id;
    private String name;

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
}
