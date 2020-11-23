package com.project1.dao;

import com.project1.model.RoleModel;

import java.util.List;

public interface IRoleDAO extends GenericDAO<RoleModel>{
    List<RoleModel> findAll();
    RoleModel findOneByName(String Name);
}
