package dao;

import models.Classification;

import java.util.List;

public interface ClassificationDAO {

    //create
    void create(Classification entity);

    //read
    List<Classification> getAll();
    Classification getById(Long id);

    //update
    void update(Classification entity);

    //delete
    void remove(Classification entity);
}