package dao;

import models.MineralSpecies;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.SessionUtilImpl;


public class MineralSpeciesDAO extends SessionUtilImpl implements DAO<MineralSpecies> {
    public MineralSpecies getById(Class persistentClass, Long id) {
        openTransactionSession();

        String sql = "SELECT * FROM Mineral_Species WHERE species_id = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(MineralSpecies.class);
        query.setParameter("id", id);

        MineralSpecies mineral = (MineralSpecies) query.getSingleResult();

        closeTransactionSession();

        return mineral;
    }
}