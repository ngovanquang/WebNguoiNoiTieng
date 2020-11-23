package com.project1.mapper;

import com.project1.model.NewModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NewMapper implements RowMapper<NewModel> {
    @Override
    public NewModel mapRow(ResultSet rs) {
        try {
            NewModel news = new NewModel();
            news.setId(rs.getLong("id"));
            news.setTitle(rs.getString("title"));
            news.setContent(rs.getString("content"));
            news.setCategoryid(rs.getLong("categoryid"));
            news.setCelebrityid(rs.getLong("celebrityid"));
            news.setHeadimg(rs.getString("headimg"));
            news.setView(rs.getLong("view"));
            news.setThumbnail(rs.getString("thumbnail"));
            news.setShortdescription(rs.getString("shortdescription"));
            news.setCreateddate(rs.getTimestamp("createddate"));
            news.setCreatedby(rs.getString("createdby"));
            if (rs.getTimestamp("modifieddate") != null) {
                news.setModifieddate(rs.getTimestamp("modifieddate"));
            }
            if (rs.getString("modifiedby") != null) {
                news.setModifiedby(rs.getString("modifiedby"));
            }
            return news;
        } catch (SQLException e) {
            return null;
        }
    }
}
