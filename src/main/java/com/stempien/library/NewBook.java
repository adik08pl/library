package com.stempien.library;

import java.time.LocalDate;

public class NewBook {
    public NewBook(){

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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAutor(String autor) {
        this.author = autor;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    private String title;
    private String author;
    private Integer year;
}
