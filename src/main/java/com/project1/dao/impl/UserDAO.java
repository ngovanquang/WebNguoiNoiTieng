package com.project1.dao.impl;

import com.project1.dao.IUserDAO;
import com.project1.mapper.UserMapper;
import com.project1.model.UserModel;
import com.project1.paging.Pageble;
import org.apache.commons.lang.StringUtils;

import java.util.List;


public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO {

	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
		StringBuilder sql = new StringBuilder("SELECT * FROM user AS u");
		sql.append(" INNER JOIN role AS r ON r.id = u.roleid");
		sql.append(" WHERE username = ? AND password = ? AND status = ?");
		List<UserModel> users = query(sql.toString(), new UserMapper(), userName, password, status);
		return users.isEmpty() ? null : users.get(0);
	}

	@Override
	public Long save(UserModel userModel) {
		StringBuilder sql = new StringBuilder("INSERT INTO user (username, password,");
		sql.append(" fullname, status, roleid, avatar, profile, createddate, createdby)");
		sql.append(" VALUES (?,?,?,?,?,?,?,?,?)");
		return insert(sql.toString(), userModel.getUserName(), userModel.getPassword(),
				userModel.getFullName(), userModel.getStatus(), userModel.getRoleId(),
				userModel.getAvatar(), userModel.getProfile(), userModel.getCreateddate(), userModel.getCreatedby());
	}

	@Override
	public void update(UserModel updateUser) {
		StringBuilder sql = new StringBuilder("UPDATE user SET username = ?, password = ?,");
		sql.append(" roleid = ?, avatar = ?, profile = ?, modifieddate = ?, modifiedby = ? WHERE id = ?");
		update(sql.toString(), updateUser.getUserName(), updateUser.getPassword(),
				updateUser.getRoleId(), updateUser.getAvatar(), updateUser.getProfile(),
				updateUser.getModifieddate(), updateUser.getModifiedby(), updateUser.getId());
	}

	@Override
	public void delete(long id) {
		String sql = "UPDATE user SET status = 0 WHERE id = ?";
		update(sql, id);
	}

	@Override
	public UserModel findOne(Long id) {
		String sql = "SELECT * FROM user WHERE id = ?";
		List<UserModel> userModels = query(sql, new UserMapper(), id);
		return userModels.isEmpty() ? null : userModels.get(0);
	}

	@Override
	public List<UserModel> findAll(Pageble pageble) {
		StringBuilder sql = new StringBuilder("SELECT * FROM user");
		if (pageble.getSorter() != null && StringUtils.isNotBlank(pageble.getSorter().getSortName()) && StringUtils.isNotBlank(pageble.getSorter().getSortBy())) {
			sql.append(" ORDER BY " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy() + "");
		}
		if (pageble.getOffset() != null && pageble.getLimit() != null) {
			sql.append(" LIMIT " + pageble.getOffset() + ", " + pageble.getLimit() + "");
		}
		return query(sql.toString(), new UserMapper());
	}

	@Override
	public int getTotalItem() {
		String sql = "SELECT count(*) FROM user";
		return count(sql);
	}

	@Override
	public List<UserModel> findAll() {
		String sql = "SELECT * FROM user";
		return query(sql, new UserMapper());
	}

}
