package com.selendemir.finalproject.mapper;

import com.selendemir.finalproject.entity.Book;
import com.selendemir.finalproject.model.author.AuthorModel;
import com.selendemir.finalproject.model.book.BookDetailModel;
import com.selendemir.finalproject.model.book.BookListModel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookMapper {

    public static BookListModel mapToBookListModel(Book book){
        BookListModel bookListModel = new BookListModel();
        bookListModel.setName(book.getName());
        bookListModel.setId(book.getId());
        List<AuthorModel> authors = AuthorMapper.mapToAuthorModels(book.getAuthors());
        bookListModel.setAuthors(authors);
        return bookListModel;
    }

    public static List<BookListModel> mapToBookListModels(List<Book> books){

        if(books == null)
            return new ArrayList<>();

        return books.stream()
                .map(BookMapper::mapToBookListModel)
                .collect(Collectors.toList());
    }

    public static BookDetailModel mapToBookDetailModel(Book book){
        BookDetailModel bookDetailModel =  new BookDetailModel();
        bookDetailModel.setId(book.getId());
        bookDetailModel.setName(book.getName());
        bookDetailModel.setDescription(book.getDescription());
        bookDetailModel.setPublicationDate(book.getPublicationDate());
        List<AuthorModel> authorModels = AuthorMapper.mapToAuthorModels(book.getAuthors());
        bookDetailModel.setAuthors(authorModels);
        return bookDetailModel;

    }

}
