package com.fmss.service;

import com.fmss.factory.ServiceFactory;
import com.fmss.model.Category;
import com.fmss.model.Product;
import com.fmss.model.Publisher;
import com.fmss.repository.CustomerRepository;
import com.fmss.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Set;

public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
        this.publisherService = ServiceFactory.createPublisherService();
        this.categoryService = ServiceFactory.createCategoryService();
    }



    private PublisherService publisherService;
    private CategoryService categoryService;



    public Product save(String name, BigDecimal price, String description, Integer unitInStock, String publisherName, String categoryName) {
        Optional<Publisher> publisher = publisherService.getByName(publisherName);
        Optional<Category> category = categoryService.getByName(categoryName);
        System.out.println(publisherService.hashCode());

        if (publisher.isEmpty()) {
            System.out.println("Publisher bulunamadı -> " + publisherName);
            throw new RuntimeException("Publisher bulunamadı -> "+ publisherName);
        }
        if (category.isEmpty()) {
            System.out.println("Category bulunamadı -> " + categoryName);
            throw new RuntimeException("Category bulunamadı -> "+ categoryName);
        }

        Product product = new Product(name, price, description, unitInStock, publisher.get(), category.get());
        productRepository.save(product);
        System.out.println("Product service saved -> " + product);
        return product;
    }

    public Set<Product> getAll() {
        return productRepository.getAll();
    }

    public void listAll() {
        getAll().forEach(System.out::println);
    }
}
