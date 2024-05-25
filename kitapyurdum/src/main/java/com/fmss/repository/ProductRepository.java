package com.fmss.repository;

import com.fmss.model.Category;
import com.fmss.model.Product;
import com.fmss.model.Publisher;

import java.util.HashSet;
import java.util.Set;

public class ProductRepository {

    private static ProductRepository instance;

    public static ProductRepository getInstance() {
        if (instance == null) {
            instance = new ProductRepository();
        }
        return instance;
    }

    private Set<Product> productSet = new HashSet<>();

    public void save(Product product) { productSet.add(product); }

    public Set<Product> getAll() { return productSet; }
}
