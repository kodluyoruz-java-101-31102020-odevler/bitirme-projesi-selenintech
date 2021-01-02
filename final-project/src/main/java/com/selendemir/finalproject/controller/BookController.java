package com.selendemir.finalproject.controller;

import com.selendemir.finalproject.model.book.BookDetailModel;
import com.selendemir.finalproject.model.book.BookListResponse;
import com.selendemir.finalproject.model.book.BookSaveRequestModel;
import com.selendemir.finalproject.service.contract.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/books")
public class BookController{

    @Autowired
    private IBookService bookService;

    @PostMapping
    public void save(@RequestBody BookSaveRequestModel request) {
        bookService.save(request);
    }

    @GetMapping("/search")
    public BookListResponse search(@RequestParam String name) {
        return bookService.search(name);
    }

    @GetMapping
    public BookListResponse getAll() {
        return bookService.getAll();
    }

    @GetMapping("/{id}")
    public BookDetailModel get(@PathVariable int id) {
        return bookService.get(id);
    }
}
