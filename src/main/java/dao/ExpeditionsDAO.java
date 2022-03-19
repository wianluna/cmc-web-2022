package dao;

import models.Expeditions;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.SessionUtilImpl;


public class ExpeditionsDAO extends SessionUtilImpl implements DAO<Expeditions> {
    public Expeditions getById(Class persistentClass, Long id) {
        openTransactionSession();

        String sql = "SELECT * FROM Expeditions WHERE expedition_id = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Expeditions.class);
        query.setParameter("id", id);

        Expeditions expedition = (Expeditions) query.getSingleResult();

        closeTransactionSession();

        return expedition;
    }
}