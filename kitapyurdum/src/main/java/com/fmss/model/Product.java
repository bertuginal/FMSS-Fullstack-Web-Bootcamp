package com.fmss.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {
    private String name;
    private BigDecimal price;
    private String description;
    private Integer unitInStock;
    private  Publisher publisher;
    private  Category category;


    public Product(String name, BigDecimal price, String description, Integer unitInStock, Publisher publisher, Category category) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.unitInStock = unitInStock;
        this.publisher = publisher;
        this.category = category;

    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\n' +
                "price=" + price + '\n' +
                "description='" + description + '\n' +
                "unitInStock=" + unitInStock + '\n' +
                "publisher=" + publisher + '\n' +
                "category=" + category + '\n' +
                '}';
    }

    public void reduceStock(Integer quantity) {
        if (quantity <= unitInStock){
            this.unitInStock -= quantity;
        } else {
            throw new IllegalArgumentException("Insufficient stock! -> " + name);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() { return  Objects.hash(name, price, description, publisher, category);}


    public BigDecimal getPrice() {
        return price;
    }
}
