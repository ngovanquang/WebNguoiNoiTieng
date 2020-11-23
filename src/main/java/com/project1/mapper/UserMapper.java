package com.project1.mapper;

import com.project1.model.RoleModel;
import com.project1.model.UserModel;

import java.sql.ResultSet;
import java.sql.SQLException;



public class UserMapper implements RowMapper<UserModel> {

	@Override
	public UserModel mapRow(ResultSet resultSet) {
		try {
			UserModel user = new UserModel();
			user.setId(resultSet.getLong("id"));
			user.setUserName(resultSet.getString("username"));
			user.setFullName(resultSet.getString("fullname"));
			user.setPassword(resultSet.getString("password"));
			user.setRoleId(resultSet.getLong("roleid"));
			user.setStatus(resultSet.getInt("status"));
			user.setAvatar(resultSet.getString("avatar"));
			user.setProfile(resultSet.getString("profile"));
			try {
				RoleModel role = new RoleModel();
				role.setCode(resultSet.getString("code"));
				role.setName(resultSet.getString("name"));
				user.setRole(role);
			} catch (Exception e) {
				System.out.print(e.getMessage());
			}
			return user;
		} catch (SQLException e) {
			return null;
		}	
	}
}
