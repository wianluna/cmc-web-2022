package dao.impl;

import utils.SessionUtil;
import dao.PhysicalPropertiesDAO;
import models.PhysicalProperties;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class PhysicalPropertiesDAOImpl extends SessionUtil implements PhysicalPropertiesDAO {

    public void create(PhysicalProperties expedition) {
        openTransactionSession();

        Session session = getSession();
        session.save(expedition);

        closeTransactionSession();
    }

    public List<PhysicalProperties> getAll() {
        openTransactionSession();

        String sql = "SELECT * FROM Physical_Properties";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(PhysicalProperties.class);
        List<PhysicalProperties> physicalPropertiesList = query.list();

        closeTransactionSession();

        return physicalPropertiesList;
    }

    public PhysicalProperties getById(Long id) {
        openTransactionSession();

        String sql = "SELECT * FROM Physical_Properties WHERE species_id = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(PhysicalProperties.class);
        query.setParameter("id", id);

        PhysicalProperties expedition = (PhysicalProperties) query.getSingleResult();

        closeTransactionSession();

        return expedition;
    }

    public void update(PhysicalProperties expedition) {
        openTransactionSession();

        Session session = getSession();
        session.update(expedition);

        closeTransactionSession();
    }

    public void remove(PhysicalProperties expedition) {
        openTransactionSession();

        Session session = getSession();
        session.remove(expedition);

        closeTransactionSession();
    }
}