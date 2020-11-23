package com.project1.dao;

import com.project1.model.CelebrityModel;

import java.util.List;

public interface ICelebrityDAO extends GenericDAO<CelebrityModel> {
    List<CelebrityModel> findAll();
    CelebrityModel findOne(Long id);
    CelebrityModel findOneByCode(String code);
}
