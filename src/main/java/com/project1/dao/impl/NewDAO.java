package com.project1.dao.impl;

import com.project1.dao.INewDAO;
import com.project1.mapper.NewMapper;
import com.project1.model.CategoryModel;
import com.project1.model.NewModel;
import com.project1.paging.Pageble;
import org.apache.commons.lang.StringUtils;

import java.util.List;

public class NewDAO extends AbstractDAO<NewModel> implements INewDAO {
    @Override
    public NewModel findOne(Long id) {
        String sql = "SELECT * FROM news WHERE id = ?";
        List<NewModel> news = query(sql, new NewMapper(), id);
        return news.isEmpty() ? null : news.get(0);
    }

    @Override
    public List<NewModel> findByCategoryId(Long categoryId) {
        String sql = "SELECT * FROM news WHERE categoryid = ?";
        return query(sql, new NewMapper(), categoryId);
    }

    @Override
    public List<NewModel> findByCelebrityId(Long celebrityId) {
        String sql = "SELECT * FROM news WHERE celebrityid = ?";
        return query(sql, new NewMapper(), celebrityId);
    }

    @Override
    public Long save(NewModel newModel) {
        StringBuilder sql = new StringBuilder("INSERT INTO news (title, content,");
        sql.append(" thumbnail, shortdescription, categoryid , celebrityid, headimg, createddate, createdby)");
        sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
        return insert(sql.toString(), newModel.getTitle(), newModel.getContent(),
                newModel.getThumbnail(), newModel.getShortdescription(), newModel.getCategoryid(),
                newModel.getCelebrityid(), newModel.getHeadimg(), newModel.getCreateddate(), newModel.getCreatedby());
    }

    @Override
    public void update(NewModel updateNew) {
        StringBuilder sql = new StringBuilder("UPDATE news SET title = ?, thumbnail = ?,");
        sql.append(" shortdescription = ?, content = ?, categoryid = ?, celebrityid = ?, headimg = ?,");
        sql.append(" modifieddate = ?, modifiedby = ?, view = ? WHERE id = ?");
        update(sql.toString(), updateNew.getTitle(), updateNew.getThumbnail(), updateNew.getShortdescription(),
                updateNew.getContent(), updateNew.getCategoryid(), updateNew.getCelebrityid(), updateNew.getHeadimg(),
                updateNew.getModifieddate(), updateNew.getModifiedby(), updateNew.getView(), updateNew.getId());
    }

    @Override
    public void delete(long id) {
        String sql = "DELETE FROM news WHERE id = ?";
        update(sql, id);
    }

    @Override
    public List<NewModel> findAll(Pageble pageble) {
        StringBuilder sql = new StringBuilder("SELECT * FROM news");
        if (pageble.getSorter() != null && StringUtils.isNotBlank(pageble.getSorter().getSortName()) && StringUtils.isNotBlank(pageble.getSorter().getSortBy())) {
            sql.append(" ORDER BY " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy() + "");
        }
        if (pageble.getOffset() != null && pageble.getLimit() != null) {
            sql.append(" LIMIT " + pageble.getOffset() + ", " + pageble.getLimit() + "");
        }
        return query(sql.toString(), new NewMapper());
    }

    @Override
    public int getTotalItem() {
        String sql = "SELECT count(*) FROM news";
        return count(sql);
    }

    @Override
    public List<NewModel> popularPost(int numberOfPopular) {
        String sql = "SELECT * FROM news ORDER BY view DESC LIMIT " + numberOfPopular;
        return  query(sql, new NewMapper());
    }

    // @Override
    // public void updateView(NewModel updateView) {
    //     String sql = "Update news SET view = ? WHERE id = ?";
    //     update(sql , updateView.getView(), updateView.getId());
    // }
}
