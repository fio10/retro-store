package com.example.retrostore.services;

import com.example.retrostore.models.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class BookService {

    public List<Book> getByGenre(String genre, List<Book> books){

        log.debug("Request Received: {}" , genre);


        System.out.println("Request Received " + genre);

        List<Book> booksByGenre = new ArrayList<>();

        for (Book book : books) {
            log.debug("Now examining book {}", book.getName());

            if (Objects.equals(book.getGenre(), genre)){
//                book.getGenre().equalsIgnoreCase()

                log.debug("Book found");

                booksByGenre.add(book);
                log.debug("My list is : {}", booksByGenre.toString());

            }
        }
        return booksByGenre;
    }


    public List<Book> getByAuthor(String author, List<Book>  books){

        List<Book> booksByAuthor = new ArrayList<>();

        for (Book book : books) {

            if (Objects.equals(book.getAuthor(),author)){
                log.info("");

                booksByAuthor.add(book);

            }
        }
        return booksByAuthor;
    }

}
