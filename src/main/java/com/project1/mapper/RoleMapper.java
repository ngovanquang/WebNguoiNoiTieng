package com.project1.mapper;

import com.project1.model.RoleModel;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleMapper implements RowMapper<RoleModel> {
    @Override
    public RoleModel mapRow(ResultSet rs) {
        try {
            RoleModel role = new RoleModel();
            role.setId(rs.getLong("id"));
            role.setName(rs.getString("name"));
            role.setCode(rs.getString("code"));
            return role;
        } catch (SQLException e) {
            return null;
        }
    }
}
