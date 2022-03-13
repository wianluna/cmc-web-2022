package dao.impl;

import utils.SessionUtil;
import dao.ExpeditionsDAO;
import models.Expeditions;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ExpeditionsDAOImpl extends SessionUtil implements ExpeditionsDAO {

    public void create(Expeditions expedition) {
        openTransactionSession();

        Session session = getSession();
        session.save(expedition);

        closeTransactionSession();
    }

    public List<Expeditions> getAll() {
        openTransactionSession();

        String sql = "SELECT * FROM Expeditions";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Expeditions.class);
        List<Expeditions> expeditionsList = query.list();

        closeTransactionSession();

        return expeditionsList;
    }

    public Expeditions getById(Long id) {
        openTransactionSession();

        String sql = "SELECT * FROM Expeditions WHERE expedition_id = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Expeditions.class);
        query.setParameter("id", id);

        Expeditions expedition = (Expeditions) query.getSingleResult();

        closeTransactionSession();

        return expedition;
    }

    public void update(Expeditions expedition) {
        openTransactionSession();

        Session session = getSession();
        session.update(expedition);

        closeTransactionSession();
    }

    public void remove(Expeditions expedition) {
        openTransactionSession();

        Session session = getSession();
        session.remove(expedition);

        closeTransactionSession();
    }
}