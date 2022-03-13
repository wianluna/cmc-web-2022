package dao;

import models.Expeditions;

import java.util.List;

public interface ExpeditionsDAO {

    //create
    void create(Expeditions entity);

    //read
    List<Expeditions> getAll();
    Expeditions getById(Long id);

    //update
    void update(Expeditions entity);

    //delete
    void remove(Expeditions entity);
}