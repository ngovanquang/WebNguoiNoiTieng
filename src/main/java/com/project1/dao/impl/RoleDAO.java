package com.project1.dao.impl;

import com.project1.dao.IRoleDAO;
import com.project1.mapper.CategoryMapper;
import com.project1.mapper.RoleMapper;
import com.project1.model.CategoryModel;
import com.project1.model.RoleModel;

import java.util.List;

public class RoleDAO extends AbstractDAO<RoleModel> implements IRoleDAO {
    @Override
    public List<RoleModel> findAll() {
        StringBuilder sql = new StringBuilder("SELECT * FROM role");
        return query(sql.toString(), new RoleMapper());
    }

    @Override
    public RoleModel findOneByName(String name) {
        String sql = "SELECT * FROM role WHERE name = ?";
        List<RoleModel> category = query(sql, new RoleMapper(), name);
        return category.isEmpty() ? null : category.get(0);
    }
}
