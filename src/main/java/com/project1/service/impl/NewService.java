package com.project1.service.impl;

import com.project1.dao.ICategoryDAO;
import com.project1.dao.ICelebrityDAO;
import com.project1.dao.INewDAO;
import com.project1.model.CategoryModel;
import com.project1.model.CelebrityModel;
import com.project1.model.NewModel;
import com.project1.paging.Pageble;
import com.project1.service.INewService;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.util.List;

public class NewService implements INewService {
    @Inject
    private INewDAO newDao;
    @Inject
    private ICategoryDAO categoryDao;
    @Inject
    private ICelebrityDAO celebrityDAO;
    @Override
    public List<NewModel> findByCategoryId(Long categoryId) {
        return newDao.findByCategoryId(categoryId);
    }

    @Override
    public NewModel save(NewModel newModel) {
        newModel.setCreateddate(new Timestamp(System.currentTimeMillis()));
        newModel.setModifieddate(new Timestamp(System.currentTimeMillis()));
        CategoryModel category = categoryDao.findOneByCode(newModel.getCategorycode());
        CelebrityModel celebrity = celebrityDAO.findOneByCode(newModel.getCelebritycode());
        newModel.setCategoryid(category.getId());
        newModel.setCelebrityid(celebrity.getId());
        Long newId = newDao.save(newModel);
        category.setAmount(category.getAmount() + 1);
        categoryDao.update(category);
        return newDao.findOne(newId);
    }

    @Override
    public NewModel update(NewModel updateNew) {
        NewModel oldNew = newDao.findOne(updateNew.getId());
        CategoryModel oldCategory = categoryDao.findOne(oldNew.getCategoryid());
        updateNew.setCreateddate(oldNew.getCreateddate());
        updateNew.setModifieddate(new Timestamp(System.currentTimeMillis()));
        CategoryModel category = categoryDao.findOneByCode(updateNew.getCategorycode());
        CelebrityModel celebrity = celebrityDAO.findOneByCode(updateNew.getCelebritycode());
        updateNew.setCategoryid(category.getId());
        updateNew.setCelebrityid(celebrity.getId());
        updateNew.setView(oldNew.getView());
        newDao.update(updateNew);
        if (updateNew.getCategoryid() != oldNew.getCategoryid()){
            oldCategory.setAmount(oldCategory.getAmount() - 1);
            categoryDao.update(oldCategory);
        }
        return newDao.findOne(updateNew.getId());
    }

    @Override
    public void delete(long[] ids) {
        NewModel newModel;
        for (Long id: ids) {
            newModel = newDao.findOne(id);
            CategoryModel categoryModel = categoryDao.findOne(newModel.getCategoryid());
            newDao.delete(id);
            categoryModel.setAmount(categoryModel.getAmount() - 1);
            categoryDao.update(categoryModel);
        }
    }

    @Override
    public List<NewModel> findAll(Pageble pageble) {
        return newDao.findAll(pageble);
    }

    @Override
    public int getTotalItem() {
        return newDao.getTotalItem();
    }

    @Override
    public NewModel findOne(long id) {
        NewModel newModel = newDao.findOne(id);
        CategoryModel category = categoryDao.findOne(newModel.getCategoryid());
        CelebrityModel celebrity = celebrityDAO.findOne(newModel.getCelebrityid());
        newModel.setCategorycode(category.getCode());
        newModel.setCelebritycode(celebrity.getCode());
        return newModel;
    }

    @Override
    public NewModel updateView(NewModel updateView) {
        updateView.setView(updateView.getView() + 1);
        newDao.update(updateView);
        return newDao.findOne(updateView.getId());
    }

    @Override
    public List<NewModel> popularPost(int numberOfPopular) {
        return newDao.popularPost(numberOfPopular);
    }
}
