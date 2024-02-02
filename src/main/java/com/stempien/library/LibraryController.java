package com.stempien.library;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LibraryController {

    Map<String , Book> books = new HashMap<>();

    @GetMapping("/save")
    @ResponseBody()
    String save(@RequestParam String title,@RequestParam String author,@RequestParam Integer year){
        books.put(title,new Book(title,author,year));
        return "Zapisano książke";
    }
    @GetMapping("/showAll")
    @ResponseBody()
    String showAll(){
        final String[] answer = {""};
        books.forEach((key, value)-> {
            answer[0] +="\nTytuł: "+key;
            answer[0] +=" Autor: "+value.author;
            answer[0] +=" Data wydania: "+value.year;

        });
        return answer[0];
    }
    @GetMapping("/showOne")
    @ResponseBody()
    String showOne(@RequestParam String key){
        String answer="";
            answer +="\nTytuł: "+books.get(key).title;
            answer +=" Autor: "+books.get(key).author;
            answer +=" Data wydania: "+books.get(key).year;
        return answer;
    }
}
