package dao;

import models.MineralSpecies;

import java.util.List;

public interface MineralSpeciesDAO {

    //create
    void create(MineralSpecies entity);

    //read
    List<MineralSpecies> getAll();
    MineralSpecies getById(Long id);

    //update
    void update(MineralSpecies entity);

    //delete
    void remove(MineralSpecies entity);
}