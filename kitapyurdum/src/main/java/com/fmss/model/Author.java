package com.fmss.model;

import java.util.Set;

public class Author {

    private String name;

    private String surname;

    private String biography;
    private Set<Book> books;

    public Author(String name, String surname, String biography) {
        this.name = name;
        this.surname = surname;
        this.biography = biography;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\n' +
                "surname='" + surname + '\n' +
                "biography='" + biography + '\n' +
                "books=" + books + '\n' +
                '}';
    }
}
