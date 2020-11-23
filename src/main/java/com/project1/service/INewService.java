package com.project1.service;

import com.project1.model.NewModel;
import com.project1.paging.Pageble;

import java.util.List;

public interface INewService {
    List<NewModel> findByCategoryId(Long categoryId);
    NewModel save(NewModel newModel);
    NewModel update(NewModel updateNew);
    void delete(long[] ids);
    List<NewModel> findAll(Pageble pageble);
    int getTotalItem();
    NewModel findOne(long id);
    NewModel updateView(NewModel updateView);
    List<NewModel> popularPost(int numberOfPopular);
}
