package com.project1.dao.impl;

import com.project1.dao.ICelebrityDAO;
import com.project1.mapper.CelebrityMapper;
import com.project1.model.CelebrityModel;

import java.util.List;

public class CelebrityDAO extends AbstractDAO<CelebrityModel> implements ICelebrityDAO  {
    @Override
    public List<CelebrityModel> findAll() {
        String sql = "SELECT * FROM celebrity";
        return query(sql, new CelebrityMapper());
    }

    @Override
    public CelebrityModel findOne(Long id) {
        String sql = "SELECT * FROM celebrity WHERE id = ?";
        List<CelebrityModel> celebrityModels = query(sql, new CelebrityMapper(), id);
        return celebrityModels.isEmpty() ? null : celebrityModels.get(0);
    }

    @Override
    public CelebrityModel findOneByCode(String code) {
        String sql = "SELECT * FROM celebrity WHERE code = ?";
        List<CelebrityModel> celebrityModels = query(sql, new CelebrityMapper(), code);
        return celebrityModels.isEmpty() ? null : celebrityModels.get(0);
    }
}
