package com.project1.service;

import com.project1.model.UserModel;
import com.project1.paging.Pageble;

import java.util.List;

public interface IUserService {
	UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status);
	UserModel save(UserModel userModel);
	UserModel update(UserModel updateUser);
	List<UserModel> findAll(Pageble pageble);
	int getTotalItem();
	void delete(long[] ids);
	UserModel findOne(long id);

    List<UserModel> findAll();
}
