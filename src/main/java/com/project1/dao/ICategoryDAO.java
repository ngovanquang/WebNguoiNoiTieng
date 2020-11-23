package com.project1.dao;

import com.project1.model.CategoryModel;

import java.util.List;

public interface ICategoryDAO extends GenericDAO<CategoryModel> {
    List<CategoryModel> findAll();
    CategoryModel findOne(Long id);
    CategoryModel findOneByCode(String code);
    void update(CategoryModel updateCategory);
    int getTotalItemFromCategory(CategoryModel categoryModel);
}
