package com.selendemir.finalproject.service.contract;

import com.selendemir.finalproject.entity.Author;
import com.selendemir.finalproject.model.author.AuthorDetailResponseModel;
import com.selendemir.finalproject.model.author.AuthorListResponse;
import com.selendemir.finalproject.model.author.AuthorSaveRequestModel;

import java.util.List;

public interface IAuthorService {

    void save(AuthorSaveRequestModel request);

    AuthorListResponse getAll();

    AuthorDetailResponseModel get(int id);

    List<Author> findAllById(List<Integer> ids);


}
