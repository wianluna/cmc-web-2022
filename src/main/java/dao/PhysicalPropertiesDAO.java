package dao;

import models.PhysicalProperties;

import java.util.List;

public interface PhysicalPropertiesDAO {
    //create
    void create(PhysicalProperties entity);

    //read
    List<PhysicalProperties> getAll();
    PhysicalProperties getById(Long id);

    //update
    void update(PhysicalProperties entity);

    //delete
    void remove(PhysicalProperties entity);
}