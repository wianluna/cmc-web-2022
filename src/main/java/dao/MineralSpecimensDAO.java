package dao;

import models.MineralSpecimens;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.SessionUtilImpl;


public class MineralSpecimensDAO extends SessionUtilImpl implements DAO<MineralSpecimens> {
    public MineralSpecimens getById(Class persistentClass, Long id) {
        openTransactionSession();

        String sql = "SELECT * FROM Mineral_Specimens WHERE specimen_id = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(MineralSpecimens.class);
        query.setParameter("id", id);

        MineralSpecimens object = (MineralSpecimens) query.getSingleResult();

        closeTransactionSession();

        return object;
    }
}