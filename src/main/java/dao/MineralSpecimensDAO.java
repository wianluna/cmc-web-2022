package dao;

import models.MineralSpecimens;

import java.util.List;

public interface MineralSpecimensDAO {

    //create
    void create(MineralSpecimens entity);

    //read
    List<MineralSpecimens> getAll();
    MineralSpecimens getById(Long id);

    //update
    void update(MineralSpecimens entity);

    //delete
    void remove(MineralSpecimens entity);
}