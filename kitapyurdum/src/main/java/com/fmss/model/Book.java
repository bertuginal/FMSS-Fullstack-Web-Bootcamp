package com.fmss.model;

import com.fmss.model.Product;

import java.math.BigDecimal;

public class Book extends Product {

    private Author author;
    public Book(String name, BigDecimal price, String description, Integer unitInStock, Publisher publisher, Category category, Author author) {

        super(name, price, description, unitInStock, publisher, category);
        this.author = author;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
