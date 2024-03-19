package com.example.retrostore.models;


import lombok.AllArgsConstructor;
import lombok.Data;

// Utilize Lombok for the constructor & getter/setters.
@Data
@AllArgsConstructor
public class Book {

    private int id;
    private String name;
    private String author;
    private double price;
    private int publishYear;
    private String genre;
    private String language;


}

