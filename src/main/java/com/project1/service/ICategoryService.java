package com.project1.service;

import com.project1.model.CategoryModel;

import java.util.List;

public interface ICategoryService {
    List<CategoryModel> findAll();
    CategoryModel findOne(long id);
    CategoryModel update(CategoryModel updateCategory);
}
