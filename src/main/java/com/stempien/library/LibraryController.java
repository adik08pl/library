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
        libraryService.save(newBook.getTitle(),newBook.getAuthor(),newBook.getYear());
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
}
