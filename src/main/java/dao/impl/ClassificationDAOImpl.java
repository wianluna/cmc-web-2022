package dao.impl;

import utils.SessionUtil;
import dao.ClassificationDAO;
import models.Classification;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ClassificationDAOImpl extends SessionUtil implements ClassificationDAO {

    public void create(Classification class_) {
        openTransactionSession();

        Session session = getSession();
        session.save(class_);

        closeTransactionSession();
    }

    public List<Classification> getAll() {
        openTransactionSession();

        String sql = "SELECT * FROM Classification";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Classification.class);
        List<Classification> classificationList = query.list();

        closeTransactionSession();

        return classificationList;
    }

    public Classification getById(Long id) {
        openTransactionSession();

        String sql = "SELECT * FROM Classification WHERE class_id = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Classification.class);
        query.setParameter("id", id);

        Classification class_ = (Classification) query.getSingleResult();

        closeTransactionSession();

        return class_;
    }

    public void update(Classification class_) {
        openTransactionSession();

        Session session = getSession();
        session.update(class_);

        closeTransactionSession();
    }

    public void remove(Classification class_) {
        openTransactionSession();

        Session session = getSession();
        session.remove(class_);

        closeTransactionSession();
    }
}