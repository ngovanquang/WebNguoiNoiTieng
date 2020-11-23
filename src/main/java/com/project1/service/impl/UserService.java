package com.project1.service.impl;

import com.project1.dao.IRoleDAO;
import com.project1.dao.IUserDAO;
import com.project1.dao.impl.UserDAO;
import com.project1.model.CategoryModel;
import com.project1.model.RoleModel;
import com.project1.model.UserModel;
import com.project1.paging.Pageble;
import com.project1.service.IUserService;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.util.List;

public class UserService implements IUserService {

	@Inject
	private IRoleDAO roleDAO;

	private IUserDAO userDAO;

	public UserService() {
		userDAO = new UserDAO();
	}
	
	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
		return userDAO.findByUserNameAndPasswordAndStatus(userName, password, status);
	}

	@Override
	public UserModel save(UserModel userModel) {
		userModel.setCreateddate(new Timestamp(System.currentTimeMillis()));
		userModel.setModifieddate(new Timestamp(System.currentTimeMillis()));
		userModel.setStatus(1);
		RoleModel role = roleDAO.findOneByName(userModel.getRoleName());
		userModel.setRoleId(role.getId());
		Long newId = userDAO.save(userModel);
		return userDAO.findOne(newId);
	}

	@Override
	public UserModel update(UserModel updateUser) {
		UserModel oldUser = userDAO.findOne(updateUser.getId());
		updateUser.setCreateddate(oldUser.getCreateddate());
		updateUser.setModifieddate(new Timestamp(System.currentTimeMillis()));
		RoleModel role = roleDAO.findOneByName(updateUser.getRoleName());
		updateUser.setRoleId(role.getId());
		userDAO.update(updateUser);
		return userDAO.findOne(updateUser.getId());
	}

	@Override
	public List<UserModel> findAll(Pageble pageble) {
		return userDAO.findAll(pageble);
	}

	@Override
	public int getTotalItem() {
		return userDAO.getTotalItem();
	}

	@Override
	public void delete(long[] ids) {
		for (Long id: ids) {
			userDAO.delete(id);
		}
	}

	@Override
	public UserModel findOne(long id) {
		return userDAO.findOne(id);
	}

	@Override
	public List<UserModel> findAll() {
		return userDAO.findAll();
	}

}
