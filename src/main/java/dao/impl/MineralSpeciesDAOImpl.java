package dao.impl;

import utils.SessionUtil;
import dao.MineralSpeciesDAO;
import models.MineralSpecies;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class MineralSpeciesDAOImpl extends SessionUtil implements MineralSpeciesDAO {

    public void create(MineralSpecies mineral) {
        openTransactionSession();

        Session session = getSession();
        session.save(mineral);

        closeTransactionSession();
    }

    public List<MineralSpecies> getAll() {
        openTransactionSession();

        String sql = "SELECT * FROM Mineral_Species";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(MineralSpecies.class);
        List<MineralSpecies> mineralSpeciesList = query.list();

        closeTransactionSession();

        return mineralSpeciesList;
    }

    public MineralSpecies getById(Long id) {
        openTransactionSession();

        String sql = "SELECT * FROM Mineral_Species WHERE species_id = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(MineralSpecies.class);
        query.setParameter("id", id);

        MineralSpecies mineral = (MineralSpecies) query.getSingleResult();

        closeTransactionSession();

        return mineral;
    }

    public void update(MineralSpecies mineral) {
        openTransactionSession();

        Session session = getSession();
        session.update(mineral);

        closeTransactionSession();
    }

    public void remove(MineralSpecies mineral) {
        openTransactionSession();

        Session session = getSession();
        session.remove(mineral);

        closeTransactionSession();
    }
}