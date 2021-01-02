package com.selendemir.finalproject.controller;

import com.selendemir.finalproject.model.author.AuthorDetailResponseModel;
import com.selendemir.finalproject.model.author.AuthorListResponse;
import com.selendemir.finalproject.model.author.AuthorSaveRequestModel;
import com.selendemir.finalproject.service.contract.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/authors")
public class AuthorController {

    @Autowired
    private IAuthorService authorService;

    @GetMapping
    public AuthorListResponse getAll(){
        return authorService.getAll();
    }

    @PostMapping
    public void save(@RequestBody AuthorSaveRequestModel request){
        authorService.save(request);
    }

    @GetMapping("/{id}")
    public AuthorDetailResponseModel get(@PathVariable int id){
        return authorService.get(id);
    }










}
