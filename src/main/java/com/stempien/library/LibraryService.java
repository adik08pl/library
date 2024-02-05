package com.stempien.library;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LibraryService {
    private final BookRepository bookRepository;

    public LibraryService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    String getOne(Integer id){
        Optional<Book> book = bookRepository.findById(id);
        if(bookRepository.findById(id).isPresent())
            return book.get().title+" "+book.get().author+" "+book.get().year;
        else
            return "Nie ma takiej książki";
    }
    String getAll(){
        List<Book> answer = (List<Book>) bookRepository.findAll();

        return answer.stream()
                .map(elem -> String.format("%s %s %d", elem.author, elem.title, elem.year))
                .collect(Collectors.joining("<br>"));
    }
    void save(String title,String author,Integer year){
        bookRepository.save(new Book(title,author,year));
    }
}
