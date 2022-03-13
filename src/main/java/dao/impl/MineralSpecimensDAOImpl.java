package dao.impl;

import utils.SessionUtil;
import dao.MineralSpecimensDAO;
import models.MineralSpecimens;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class MineralSpecimensDAOImpl extends SessionUtil implements MineralSpecimensDAO {

    public void create(MineralSpecimens object) {
        openTransactionSession();

        Session session = getSession();
        session.save(object);

        closeTransactionSession();
    }

    public List<MineralSpecimens> getAll() {
        openTransactionSession();

        String sql = "SELECT * FROM Mineral_Specimens";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(MineralSpecimens.class);
        List<MineralSpecimens> mineralSpecimensList = query.list();

        closeTransactionSession();

        return mineralSpecimensList;
    }

    public MineralSpecimens getById(Long id) {
        openTransactionSession();

        String sql = "SELECT * FROM Mineral_Specimens WHERE specimen_id = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(MineralSpecimens.class);
        query.setParameter("id", id);

        MineralSpecimens object = (MineralSpecimens) query.getSingleResult();

        closeTransactionSession();

        return object;
    }

    public void update(MineralSpecimens object) {
        openTransactionSession();

        Session session = getSession();
        session.update(object);

        closeTransactionSession();
    }

    public void remove(MineralSpecimens object) {
        openTransactionSession();

        Session session = getSession();
        session.remove(object);

        closeTransactionSession();
    }
}