package com.selendemir.finalproject.repository;

import com.selendemir.finalproject.aspect.RunningTime;
import com.selendemir.finalproject.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    @RunningTime
    @Query(value = "select distinct b from Book b left join b.authors where b.name like %:name%")
    List<Book> search(@Param("name") String name);

    @RunningTime
    @Query(value = "select distinct b from Book b left join b.authors")
    List<Book> getAll();

    @RunningTime
    @Query(value = "select distinct b from Book b left join b.authors where b.id = :id")
    Book getBookById(@Param("id") int id);

    @RunningTime
    @Query(value = "select distinct b from Book b left join b.authors a where a.id = :authorId")
    List<Book> getBooksByAuthorId(@Param("authorId") int authorId);
}
