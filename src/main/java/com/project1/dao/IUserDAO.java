package com.project1.dao;


import com.project1.model.UserModel;
import com.project1.paging.Pageble;

import java.util.List;

public interface IUserDAO extends GenericDAO<UserModel> {
	UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status);
	Long save(UserModel userModel);
	void update(UserModel userModel);
	void delete(long id);
	UserModel findOne(Long id);
	List<UserModel> findAll(Pageble pageble);
	int getTotalItem();
    List<UserModel> findAll();
}
