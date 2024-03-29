package com.stempien.library;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    public String title;
    public String author;
    public Integer year;
    public String genre;
    public String ISBN;
    public Boolean isAvaiable;
    public Book(){

    }

    public Book(String title, String author, Integer year, String gegre, String ISBN, Boolean isAvaiable) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.genre = gegre;
        this.ISBN = ISBN;
        this.isAvaiable = isAvaiable;
    }
}
