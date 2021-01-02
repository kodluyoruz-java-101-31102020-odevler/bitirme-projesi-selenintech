package com.selendemir.finalproject.service.contract;

import com.selendemir.finalproject.model.book.BookDetailModel;
import com.selendemir.finalproject.model.book.BookListModel;
import com.selendemir.finalproject.model.book.BookListResponse;
import com.selendemir.finalproject.model.book.BookSaveRequestModel;

import java.util.List;

public interface IBookService {

    void save(BookSaveRequestModel request);

    BookListResponse search(String name);

    BookListResponse getAll();

    BookDetailModel get(int id);

    List<BookListModel> getAllByAuthorId(int authorId);
}
