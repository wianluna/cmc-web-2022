package dao;

import models.Classification;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.SessionUtilImpl;


public class ClassificationDAO extends SessionUtilImpl implements DAO<Classification> {
    public Classification getById(Class persistentClass, Long id) {
        openTransactionSession();

        String sql = "SELECT * FROM Classification WHERE class_id = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Classification.class);
        query.setParameter("id", id);

        Classification class_ = (Classification) query.getSingleResult();

        closeTransactionSession();

        return class_;
    }
}