package com.project1.mapper;

import com.project1.model.CelebrityModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CelebrityMapper implements RowMapper<CelebrityModel> {
    @Override
    public CelebrityModel mapRow(ResultSet rs) {
        try {
            CelebrityModel celebrity = new CelebrityModel();
            celebrity.setId(rs.getLong("id"));
            celebrity.setCode(rs.getString("code"));
            celebrity.setName(rs.getString("name"));
            celebrity.setDob(rs.getInt("dob"));
            celebrity.setNationality(rs.getString("nationality"));
            celebrity.setCity(rs.getString("city"));
            celebrity.setAvatar(rs.getNString("avatar"));
            celebrity.setProfile(rs.getNString("profile"));
            return celebrity;
        } catch (SQLException e) {
            return null;
        }
    }
}
