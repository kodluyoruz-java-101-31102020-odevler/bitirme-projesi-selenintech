package com.selendemir.finalproject.mapper;

import com.selendemir.finalproject.entity.Author;
import com.selendemir.finalproject.model.author.AuthorModel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AuthorMapper {

    public static AuthorModel mapToAuthorModel(Author entity){
        AuthorModel model =  new AuthorModel();
        model.setId(entity.getId());
        model.setName(entity.getName());
        return model;
    }

    public static List<AuthorModel> mapToAuthorModels(List<Author> entities){

        if(entities == null)
            return new ArrayList<>();

        return entities.stream()
                .map(AuthorMapper::mapToAuthorModel)
                .collect(Collectors.toList());
    }
}
