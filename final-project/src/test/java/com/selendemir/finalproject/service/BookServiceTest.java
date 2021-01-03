package com.selendemir.finalproject.service;

import com.selendemir.finalproject.entity.Author;
import com.selendemir.finalproject.entity.Book;
import com.selendemir.finalproject.model.author.AuthorModel;
import com.selendemir.finalproject.model.book.BookDetailModel;
import com.selendemir.finalproject.model.book.BookListModel;
import com.selendemir.finalproject.model.book.BookListResponse;
import com.selendemir.finalproject.repository.BookRepository;
import com.selendemir.finalproject.service.implementation.BookService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Before
    public void setUp(){

        Book book =  new Book();
        book.setId(12);
        book.setName("güç");
        book.setDescription("güç kullanımı");
        book.setPublicationDate(new Date());
        Author author = new Author();
        author.setId(10);
        author.setName("tess");
        author.setBooks(Arrays.asList(book));
        book.setAuthors(Arrays.asList(author));


        Book book2 =  new Book();
        book2.setId(14);
        book2.setName("bela");
        book2.setDescription("bela bulaşmak");
        book2.setPublicationDate(new Date());
        Author author2 = new Author();
        author2.setId(14);
        author2.setName("gerit");
        author2.setBooks(Arrays.asList(book2));
        book2.setAuthors(Arrays.asList(author2));

        Mockito
                .when(bookRepository.search("güç"))
                .thenReturn(Arrays.asList(book));
        Mockito
                .when(bookRepository.getBookById(12))
                .thenReturn(book);
        Mockito
                .when(bookRepository.getAll())
                .thenReturn(Arrays.asList(book,book2));
        Mockito
                .when(bookRepository.getBooksByAuthorId(author.getId()))
                .thenReturn(author.getBooks());

    }





    @Test
    public void testSearchBook(){
        BookListResponse searchResult = bookService.search("güç");
        Assert.assertEquals(1, searchResult.getBooks().size());
    }

    @Test
    public void testGetAllBooks(){
        BookListResponse result = bookService.getAll();
        Assert.assertEquals(2, result.getBooks().size());
    }
    @Test
    public void testGetBook(){
        BookDetailModel book = bookService.get(12);
        Assert.assertEquals(12,book.getId());
        Assert.assertEquals("güç",book.getName());
        Assert.assertEquals("güç kullanımı",book.getDescription());
        AuthorModel author = book.getAuthors().get(0);
        Assert.assertEquals(10,author.getId());
        Assert.assertEquals("tess",author.getName());

    }

    @Test
    public void testGetAllBooksByAuthorId(){
        List<BookListModel> books = bookService.getAllByAuthorId(10);
        Assert.assertEquals(1, books.size());
    }



}
