package com.selendemir.finalproject.service;

import com.selendemir.finalproject.entity.Author;
import com.selendemir.finalproject.entity.Book;
import com.selendemir.finalproject.mapper.BookMapper;
import com.selendemir.finalproject.model.author.AuthorDetailResponseModel;
import com.selendemir.finalproject.model.author.AuthorListResponse;
import com.selendemir.finalproject.model.book.BookListModel;
import com.selendemir.finalproject.repository.AuthorRepository;
import com.selendemir.finalproject.service.implementation.AuthorService;
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
public class AuthorServiceTest {

    @Mock
    private AuthorRepository authorRepository;

    @Mock
    private BookService bookService;

    @InjectMocks
    private AuthorService authorService;



    @Before
    public void setUp(){

        Author author = new Author();
        author.setId(16);
        author.setName("jane");
        Book book =  new Book();
        book.setId(12);
        book.setName("güç");
        book.setDescription("güç kullanımı");
        book.setPublicationDate(new Date());
        Book book2 =  new Book();
        book2.setId(14);
        book2.setName("bela");
        book2.setDescription("bela bulaşmak");
        book2.setPublicationDate(new Date());
        author.setBooks(Arrays.asList(book,book2));
        List<BookListModel> bookListModels = BookMapper.mapToBookListModels(Arrays.asList(book, book2));

        Mockito
                .when(bookService.getAllByAuthorId(16))
                .thenReturn(bookListModels);



        Mockito
                .when(authorRepository.findAll())
                .thenReturn(Arrays.asList(author));

        Mockito
                .when(authorRepository.findAuthorById(16))
                .thenReturn(author);

    }

    @Test
    public void testGetAllByAuthorId(){
        AuthorDetailResponseModel authorDetail = authorService.get(16);
        Assert.assertEquals("jane", authorDetail.getAuthor().getName());
        Assert.assertEquals(16,authorDetail.getAuthor().getId());
        Assert.assertEquals(2,authorDetail.getBooks().size());
    }

    @Test
    public void testGetAll(){
        AuthorListResponse authorListResponse = authorService.getAll();
        Assert.assertEquals(1,authorListResponse.getAuthors().size());
    }





}
