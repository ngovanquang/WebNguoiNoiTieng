package com.project1.service.impl;

import com.project1.dao.IRoleDAO;
import com.project1.model.RoleModel;
import com.project1.service.IRoleService;

import javax.inject.Inject;
import java.util.List;



public class RoleService implements IRoleService {
    @Inject
    private IRoleDAO roleDAO;
    @Override
    public List<RoleModel> findAll() {
        return roleDAO.findAll();
    }
}
