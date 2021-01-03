package com.selendemir.finalproject.service.implementation;

import com.selendemir.finalproject.aspect.RunningTime;
import com.selendemir.finalproject.entity.Author;
import com.selendemir.finalproject.entity.Book;
import com.selendemir.finalproject.exception.EntityNotFoundException;
import com.selendemir.finalproject.mapper.BookMapper;
import com.selendemir.finalproject.model.book.BookDetailModel;
import com.selendemir.finalproject.model.book.BookListModel;
import com.selendemir.finalproject.model.book.BookListResponse;
import com.selendemir.finalproject.model.book.BookSaveRequestModel;
import com.selendemir.finalproject.repository.BookRepository;
import com.selendemir.finalproject.service.contract.IAuthorService;
import com.selendemir.finalproject.service.contract.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookService implements IBookService {

    @Autowired
    private BookRepository bookRepository;

    @Lazy
    @Autowired
    private IAuthorService authorService;

    @RunningTime
    @Override
    public void save(BookSaveRequestModel request) {
        List<Author> authors = authorService.findAllById(request.getAuthorIds());
        Book entity = new Book();
        entity.setName(request.getName());
        entity.setPublicationDate(request.getPublicationDate());
        entity.setDescription(request.getDescription());
        entity.setAuthors(authors);
        bookRepository.save(entity);
    }

    @RunningTime
    @Override
    public BookListResponse search(String name) {

        if (name == null || name.length() == 0)
            return getAll();

        List<Book> entities = bookRepository.search(name);
        BookListResponse bookListResponse = new BookListResponse();
        List<BookListModel> bookListModels = BookMapper.mapToBookListModels(entities);
        bookListResponse.setBooks(bookListModels);
        return  bookListResponse;
    }

    @RunningTime
    @Override
    public BookListResponse getAll() {
        List<Book> books = bookRepository.getAll();
        BookListResponse bookListResponse =  new BookListResponse();
        List<BookListModel> bookListModels = BookMapper.mapToBookListModels(books);
        bookListResponse.setBooks(bookListModels);
        return bookListResponse;
    }

    @RunningTime
    @Override
    public BookDetailModel get(int id) {
        Book book = bookRepository.getBookById(id);
        if(book == null)
            throw new EntityNotFoundException("Book is not found");
        return BookMapper.mapToBookDetailModel(book);
    }

    @RunningTime
    @Override
    public List<BookListModel> getAllByAuthorId(int authorId) {
        List<Book> books = bookRepository.getBooksByAuthorId(authorId);
        return BookMapper.mapToBookListModels(books);
    }



}
