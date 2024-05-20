package com.fmss.model;

import java.time.LocalDate;
import java.util.List;

public class Publisher {

    private String name;
    private LocalDate createDate;

    //private List<Book> bookList;


    public Publisher(String name, LocalDate createDate) {
        this.name = name;
        this.createDate = createDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "name='" + name + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
