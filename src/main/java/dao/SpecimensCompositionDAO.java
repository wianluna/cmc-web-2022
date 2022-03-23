package dao;

import models.SpecimensComposition;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.SessionUtilImpl;

public class SpecimensCompositionDAO extends SessionUtilImpl implements DAO<SpecimensComposition>  {
    public SpecimensComposition getById(Long specimen_id, Long species_id) {
        String sql = "SELECT * FROM Specimens_Composition WHERE species_id = :species_id AND specimen_id = :specimen_id";

        Session session = openSession();
        Query query = session.createNativeQuery(sql).addEntity(SpecimensComposition.class);
        query.setParameter("species_id", species_id);
        query.setParameter("specimen_id", specimen_id);

        SpecimensComposition entity = (SpecimensComposition) query.getSingleResult();
        closeSession();
        return entity;
    }
}