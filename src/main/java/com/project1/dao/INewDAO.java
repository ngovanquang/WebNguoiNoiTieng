package com.project1.dao;

import com.project1.model.NewModel;
import com.project1.paging.Pageble;

import java.util.List;

public interface INewDAO extends GenericDAO<NewModel> {
    NewModel findOne(Long id);
    List<NewModel> findByCategoryId(Long categoryId);
    List<NewModel> findByCelebrityId(Long celebrityId);
    Long save(NewModel newModel);
    void update(NewModel updateNew);
    void delete(long id);
    List<NewModel> findAll(Pageble pageble);
    int getTotalItem();
    List<NewModel> popularPost(int numberOfPopular);
    //void updateView(NewModel updateView);
}
