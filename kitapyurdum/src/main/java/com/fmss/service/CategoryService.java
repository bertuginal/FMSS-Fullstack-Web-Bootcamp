package com.fmss.service;

import com.fmss.model.Category;
import com.fmss.model.Publisher;
import com.fmss.repository.CategoryRepository;
import com.fmss.repository.PublisherRepository;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

public class CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category save(String name) {
        Category category = new Category(name);
        categoryRepository.save(category);
        return category;
    }

    public List<Category> getAll() { return categoryRepository.getAll(); }

    public Optional<Category> getByName(String categoryName) {
        return getAll()
                .stream()
                .filter(category -> category.getName().equals(categoryName))
                .findFirst();
    }
}
