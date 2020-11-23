package com.project1.service.impl;

import com.project1.dao.ICategoryDAO;
import com.project1.model.CategoryModel;
import com.project1.service.ICategoryService;

import javax.inject.Inject;
import java.util.List;

public class CategoryService implements ICategoryService {
    @Inject
    private ICategoryDAO categoryDao;

    @Override
    public List<CategoryModel> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public CategoryModel findOne(long id) {
        return categoryDao.findOne(id);

    }

    @Override
    public CategoryModel update(CategoryModel updateCategory) {
         categoryDao.update(updateCategory);
         return categoryDao.findOne(updateCategory.getId());
    }

}
