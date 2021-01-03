package com.selendemir.finalproject.service.implementation;

import com.selendemir.finalproject.aspect.RunningTime;
import com.selendemir.finalproject.entity.Author;
import com.selendemir.finalproject.exception.EntityNotFoundException;
import com.selendemir.finalproject.mapper.AuthorMapper;
import com.selendemir.finalproject.model.author.AuthorDetailResponseModel;
import com.selendemir.finalproject.model.author.AuthorListResponse;
import com.selendemir.finalproject.model.author.AuthorModel;
import com.selendemir.finalproject.model.author.AuthorSaveRequestModel;
import com.selendemir.finalproject.model.book.BookListModel;
import com.selendemir.finalproject.repository.AuthorRepository;
import com.selendemir.finalproject.service.contract.IAuthorService;
import com.selendemir.finalproject.service.contract.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AuthorService implements IAuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private IBookService bookService;

    @RunningTime
    @Override
    public void save(AuthorSaveRequestModel request) {
        Author entity = new Author();
        entity.setName(request.getName());
        authorRepository.save(entity);
    }

    @RunningTime
    @Override
    public AuthorListResponse getAll() {
        List<Author> entities = authorRepository.findAll();
        List<AuthorModel> authorModels = AuthorMapper.mapToAuthorModels(entities);
        AuthorListResponse authorListResponse =  new AuthorListResponse();
        authorListResponse.setAuthors(authorModels);
        return authorListResponse;
    }

    @RunningTime
    @Override
    public AuthorDetailResponseModel get(int id) {
        Author entity = authorRepository.findAuthorById(id);
        if(entity == null)
            throw new EntityNotFoundException("Entity is not found!");

        List<BookListModel> books = bookService.getAllByAuthorId(id);
        AuthorModel authorModel = AuthorMapper.mapToAuthorModel(entity);
        AuthorDetailResponseModel response = new AuthorDetailResponseModel();
        response.setAuthor(authorModel);
        response.setBooks(books);
        return response;
    }

    @RunningTime
    @Override
    public List<Author> findAllById(List<Integer> ids) {
        return authorRepository.findAllById(ids);
    }


}
