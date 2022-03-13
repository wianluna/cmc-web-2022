package dao.impl;

import utils.SessionUtil;
import dao.SpecimensCompositionDAO;
import models.SpecimensComposition;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class SpecimensCompositionDAOImpl extends SessionUtil implements SpecimensCompositionDAO {

    public void create(SpecimensComposition entity) {
        openTransactionSession();

        Session session = getSession();
        session.save(entity);

        closeTransactionSession();
    }

    public List<SpecimensComposition> getAll() {
        openTransactionSession();

        String sql = "SELECT * FROM Specimens_Composition";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(SpecimensComposition.class);
        List<SpecimensComposition> specimensCompositionList = query.list();

        closeTransactionSession();

        return specimensCompositionList;
    }

    public SpecimensComposition getById(Long species_id, Long specimen_id) {
        openTransactionSession();

        String sql = "SELECT * FROM Specimens_Composition WHERE species_id = :species_id AND specimen_id = :specimen_id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(SpecimensComposition.class);
        query.setParameter("species_id", species_id);
        query.setParameter("specimen_id", specimen_id);

        SpecimensComposition entity = (SpecimensComposition) query.getSingleResult();

        closeTransactionSession();

        return entity;
    }

    public void update(SpecimensComposition entity) {
        openTransactionSession();

        Session session = getSession();
        session.update(entity);

        closeTransactionSession();
    }

    public void remove(SpecimensComposition entity) {
        openTransactionSession();

        Session session = getSession();
        session.remove(entity);

        closeTransactionSession();
    }
}