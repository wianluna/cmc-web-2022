package dao;

import models.PhysicalProperties;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.SessionUtilImpl;


public class PhysicalPropertiesDAO extends SessionUtilImpl implements DAO<PhysicalProperties> {
    public PhysicalProperties getById(Class persistentClass, Long id) {
        openTransactionSession();

        String sql = "SELECT * FROM Physical_Properties WHERE species_id = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(PhysicalProperties.class);
        query.setParameter("id", id);

        PhysicalProperties expedition = (PhysicalProperties) query.getSingleResult();

        closeTransactionSession();

        return expedition;
    }
}