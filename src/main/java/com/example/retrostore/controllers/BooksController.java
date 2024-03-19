package com.example.retrostore.controllers;

import com.example.retrostore.models.Book;
import com.example.retrostore.services.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/books")
@Slf4j
public class BooksController {


    private List<Book> books = new ArrayList<Book>();

    private AtomicInteger counter = new AtomicInteger();

    @Autowired
    private BookService bookService ;


//    Generate some books as we don't have a database yet available.

    public BooksController(){

        books.add(new Book(counter.incrementAndGet(), "A tale of two cities", "Charles Dickens",20, 1859,"Historical Fiction", "English"));
        books.add(new Book(counter.incrementAndGet(), "The little prince", "Antoine de Saint-Exupery",19, 1943,"Fantasy, Children's fiction", "French"));
        books.add(new Book(counter.incrementAndGet(), "Harry Potter and the Philosopher's Stone", "J.K Rowling",30, 1997,"Fantasy, Children's fiction", "English"));
        books.add(new Book(counter.incrementAndGet(), "And Then There Were None", "Agatha Cristie",16, 1939,"Mystery", "English"));
        books.add(new Book(counter.incrementAndGet(), "Dream of the Red Chamber", "Cao Xueqin",22, 1791,"Mystery", "Chinese"));
        books.add(new Book(counter.incrementAndGet(), "The Hobbit", "J.R.R. Tolkien",28, 1937,"Fantasy, Children's fiction", "English"));

    }


//    The below will be responsible to return the complete list of books.

    @GetMapping
    public List<Book> getBooks(){

        return books;
    }

//    The below will retrieve books for a specific type

    @GetMapping("/genre/{genre}")
    public List<Book> getBooks(@PathVariable String genre){

        return bookService.getByGenre(genre,books);

    }


    @GetMapping("/books")
    public List<Book> getBooksByAuthor(@RequestParam("author") String author) {

        log.info("Received author parameter: {}", author);
        return bookService.getByAuthor(author, books);

    }






    /*

    CURL to run:

    curl -X PUT localhost:8080/books -H 'Content-type:application/json' -d '{"name": "FJ Odyssey", "author": "F.J. Mali" , "price": 23, "publishYear":2029, "genre":"Biography","language":"English"}'

    curl -X POST localhost:8080/books -H 'Content-type:application/json' -d '{"name": "FJ Odyssey", "author": "F.J. Mali" , "price": 23, "publishYear":2029, "genre":"Biography","language":"English"}'

    books addition command:

    books.add(new Book(counter.incrementAndGet(), "FJ Odyssey", "F.J. Mali",23, 2029,"Biography", "English"));


     */


    @PostMapping(
            value = "/books", consumes = "application/json", produces = "application/json")
    public  List<Book> addBook(@RequestBody Book book){

        books.add(new Book(counter.incrementAndGet(), "FJ Odyssey", "F.J. Mali",23, 2029,"Biography", "English"));

        return books;
    }


}
