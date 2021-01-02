package com.selendemir.finalproject.repository;

import com.selendemir.finalproject.aspect.RunningTime;
import com.selendemir.finalproject.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer > {

    @RunningTime
    @Query(value = "select a from Author a where a.id = :id ")
    Author findAuthorById(@Param("id") int id);

    @RunningTime
    @Query(value = "select a from Author a where a.id in (:ids) ")
    List<Author> findAllById(@Param("ids") List<Integer> ids);




}
