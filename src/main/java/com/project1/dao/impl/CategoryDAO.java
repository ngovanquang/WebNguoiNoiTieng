package com.project1.dao.impl;

import com.project1.dao.ICategoryDAO;
import com.project1.mapper.CategoryMapper;
import com.project1.model.CategoryModel;

import java.util.List;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {
    @Override
    public List<CategoryModel> findAll() {
        String sql = "SELECT * FROM category";
        return query(sql, new CategoryMapper());
    }

    @Override
    public CategoryModel findOne(Long id) {
        String sql = "SELECT * FROM category WHERE id = ?";
        List<CategoryModel> category = query(sql, new CategoryMapper(), id);
        return category.isEmpty() ? null : category.get(0);
    }

    @Override
    public CategoryModel findOneByCode(String code) {
        String sql = "SELECT * FROM category WHERE code = ?";
        List<CategoryModel> category = query(sql, new CategoryMapper(), code);
        return category.isEmpty() ? null : category.get(0);
    }

    @Override
    public void update(CategoryModel updateCategory) {
        String sql = "UPDATE category SET name = ?, code = ?, amount = ? WHERE id = ?";
        update(sql, updateCategory.getName(), updateCategory.getCode(), updateCategory.getAmount(), updateCategory.getId());
    }

    @Override
    public int getTotalItemFromCategory(CategoryModel category) {
        String sql = "SELECT count(*) FROM category WHERE id = ?";
        return count(sql, category.getId());
    }

}
