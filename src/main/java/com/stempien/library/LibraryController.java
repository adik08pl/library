package com.stempien.library;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LibraryController {

    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @PostMapping("/save")
    @ResponseBody()
    String save(@RequestBody NewBook newBook){
        libraryService.save(newBook.getTitle(),newBook.getAuthor(),newBook.getYear(),newBook.getGenre(),newBook.getISBN(),newBook.getAvaiable());
        return "Zapisano książke";
    }
    @GetMapping("/showAll")
    @ResponseBody()
    String showAll(){
        return libraryService.getAll();
    }
    @GetMapping("/showOne")
    @ResponseBody()
    String showOne(@RequestParam Integer id){
        return libraryService.getOne(id);
    }
    @GetMapping("/generate")
    @ResponseBody()
    void generate(){
        libraryService.generate();
    }
    @GetMapping("/useAll")
    @ResponseBody()
    String useAll(@RequestParam int id,@RequestParam String author,@RequestParam String title,@RequestParam String genre,@RequestParam int year1,@RequestParam int year2){
        return libraryService.useAll(id,author,title,genre,year1,year2);
    }
}
