package com.project1.service.impl;

import com.project1.dao.ICelebrityDAO;
import com.project1.model.CelebrityModel;
import com.project1.service.ICelebrityService;

import javax.inject.Inject;
import java.util.List;

public class CelebrityService implements ICelebrityService {
    @Inject
    private ICelebrityDAO celebrityDAO;
    @Override
    public List<CelebrityModel> findAll() {
        return celebrityDAO.findAll();
    }
}
