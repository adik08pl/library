package com.stempien.library;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book,Integer> {
    List<Book> findByAuthor(String author);
    List<Book> findByTitleLike(String title);
    List<Book> findByIsAvaiableTrue();
    List<Book> findByIsAvaiableFalse();
    List<Book> findByGenreLike(String genre);
    int countByAuthor(String author);
    List<Book> deleteByYearLessThan(int year);
    List<Book> findByTitleStartingWith(String titleStart);
    List<Book> findByISBNIsNotNull();
    List<Book> findByYearBetween(int year1,int year2);
    List<Book> findByAuthorAndGenre(String author,String genre);
    List<Book> findAllByOrderByYearDesc();
    List<Book> findByTitleEndingWith(String titleEnding);
    List<Book> findByTitleOrAuthorLike(String title,String author);

}
