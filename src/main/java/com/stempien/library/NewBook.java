package com.stempien.library;

import java.time.LocalDate;

public class NewBook {
    public NewBook(){

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setGegre(String genre) {
        this.genre = genre;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setAvaiable(Boolean avaiable) {
        isAvaiable = avaiable;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public String getISBN() {
        return ISBN;
    }

    public Boolean getAvaiable() {
        return isAvaiable;
    }

    private String title;
    private String author;
    private Integer year;
    private String genre;
    private String ISBN;
    private Boolean isAvaiable;
}
