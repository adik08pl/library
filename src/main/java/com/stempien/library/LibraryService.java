package com.stempien.library;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class LibraryService {
    Random random = new Random();
    private final BookRepository bookRepository;

    public LibraryService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    String getOne(Integer id){
        Optional<Book> book = bookRepository.findById(id);
        return book
                .map(value -> value.title + " " + value.author + " " + value.year)
                .orElse("Nie ma takiej książki");
    }
    String getAll(){
        List<Book> answer = (List<Book>) bookRepository.findAll();

        return answer.stream()
                .map(elem -> String.format("%s %s %d", elem.author, elem.title, elem.year))
                .collect(Collectors.joining("<br>"));
    }
    void save(String title, String author, Integer year, String gegre, String ISBN, Boolean isAvaiable){
        bookRepository.save(new Book(title, author, year, gegre, ISBN,isAvaiable));
    }

    void generate() {
        for (int i = 0; i < 5; i++) {
            String title = String.valueOf(random.nextInt(99) + 1);
            String author = String.valueOf(random.nextInt(99) + 1);
            Integer year = random.nextInt(80) + 1960;
            String gegre = String.valueOf(random.nextInt(99) + 1);
            String ISBN = String.valueOf(random.nextInt(999999) + 1);
            Boolean isAvaiable = random.nextInt(2) == 1;
            bookRepository.save(new Book(title,author,year,gegre,ISBN,isAvaiable));
        }
    }
    String useAll(int id, String author,String title,String genre, int year1,int year2){
        String answer="";
        answer+=bookRepository.findByAuthor(author).stream().map(elem -> String.format("%s %s %d", elem.author, elem.title, elem.year))
                .collect(Collectors.joining("<br>"));;
        answer+=bookRepository.findByTitleLike(title).stream().map(elem -> String.format("%s %s %d", elem.author, elem.title, elem.year))
                .collect(Collectors.joining("<br>"));;;
        answer+=bookRepository.findByIsAvaiableTrue().stream().map(elem -> String.format("%s %s %d", elem.author, elem.title, elem.year))
                .collect(Collectors.joining("<br>"));;;
        answer+=bookRepository.findByIsAvaiableFalse().stream().map(elem -> String.format("%s %s %d", elem.author, elem.title, elem.year))
                .collect(Collectors.joining("<br>"));;;
        answer+=bookRepository.findByGenreLike(genre).stream().map(elem -> String.format("%s %s %d", elem.author, elem.title, elem.year))
                .collect(Collectors.joining("<br>"));;;
        answer+=bookRepository.countByAuthor(author);
        bookRepository.deleteByYearLessThan(year1).stream().map(elem -> String.format("%s %s %d", elem.author, elem.title, elem.year))
                .collect(Collectors.joining("<br>"));;;
        answer+=bookRepository.findByTitleStartingWith(title).stream().map(elem -> String.format("%s %s %d", elem.author, elem.title, elem.year))
                .collect(Collectors.joining("<br>"));;;
        answer+=bookRepository.findByISBNIsNotNull().stream().map(elem -> String.format("%s %s %d", elem.author, elem.title, elem.year))
                .collect(Collectors.joining("<br>"));;;
        answer+=bookRepository.findByYearBetween(year1,year2).stream().map(elem -> String.format("%s %s %d", elem.author, elem.title, elem.year))
                .collect(Collectors.joining("<br>"));;;
        answer+=bookRepository.findByAuthorAndGenre(author,genre).stream().map(elem -> String.format("%s %s %d", elem.author, elem.title, elem.year))
                .collect(Collectors.joining("<br>"));;;
        answer+=bookRepository.findAllByOrderByYearDesc().stream().map(elem -> String.format("%s %s %d", elem.author, elem.title, elem.year))
                .collect(Collectors.joining("<br>"));;;
        answer+=bookRepository. findByTitleEndingWith(title).stream().map(elem -> String.format("%s %s %d", elem.author, elem.title, elem.year))
                .collect(Collectors.joining("<br>"));;;
        answer+=bookRepository. findByTitleOrAuthorLike(title,author).stream().map(elem -> String.format("%s %s %d", elem.author, elem.title, elem.year))
                .collect(Collectors.joining("<br>"));;;
        return answer;
    }
}
