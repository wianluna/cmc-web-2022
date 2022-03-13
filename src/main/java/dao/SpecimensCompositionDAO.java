package dao;

import models.SpecimensComposition;

import java.util.List;

public interface SpecimensCompositionDAO {

    //create
    void create(SpecimensComposition entity);

    //read
    List<SpecimensComposition> getAll();
    SpecimensComposition getById(Long species_id, Long specimen_id);

    //update
    void update(SpecimensComposition entity);

    //delete
    void remove(SpecimensComposition entity);
}