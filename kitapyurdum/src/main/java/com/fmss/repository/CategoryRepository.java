package com.fmss.repository;

import com.fmss.model.Category;
import com.fmss.model.Publisher;

import java.util.ArrayList;
import java.util.List;

public class CategoryRepository {

    private List<Category> categoryList = new ArrayList<>();

    public void save(Category category) { categoryList.add(category); }

    public List<Category> getAll() { return categoryList; }

}
