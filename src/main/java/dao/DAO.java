package dao;

import org.hibernate.Criteria;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.query.Query;
import utils.SessionUtil;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public interface DAO<E> extends SessionUtil {
    default void create(E entity) {
        openTransactionSession();

        Session session = getSession();
        session.save(entity);

        closeTransactionSession();
    }

    default List<E> getAll(Class persistentClass) {
        Session session = openSession();
        Query query = session.createQuery("from " + persistentClass.getName());

        List<E> result = query.list();
        closeSession();
        return result;
    }

    default void update(E entity) {
        openTransactionSession();

        Session session = getSession();
        session.update(entity);

        closeTransactionSession();
    }

    default void remove(E entity) {
        openTransactionSession();

        Session session = getSession();
        session.remove(entity);

        closeTransactionSession();
    }

    default E getById(Class persistentClass, Long id) {
        Session session = openSession();;
        E entity = (E) session.get(persistentClass, id);
        closeSession();
        return entity;
    }

    default List<E> filter(Class persistentClass, Map<String, List> filters) {
        openTransactionSession();
        Session session = getSession();
        filters.entrySet().forEach(entry -> {
            String filterName = entry.getKey();
            List parameters = entry.getValue();
            Filter enableFilter = session.enableFilter(filterName);
            Set<String> paramNames = enableFilter.getFilterDefinition().getParameterNames();
            AtomicInteger i = new AtomicInteger();
            paramNames.forEach(name ->
                    enableFilter.setParameter(name, parameters.get(i.getAndIncrement()))
            );
        });

        Query query = session.createQuery("from " + persistentClass.getName());

        List<E> result = query.list();
        closeTransactionSession();
        return result;
    }

    default List<E> sort(Class persistentClass, Map<String, String> order) {
        Session session = openSession();
        Criteria criteria = session.createCriteria(persistentClass, "CRITERIA");
        order.forEach((key, value) -> {
            if (value.equals("asc")) {
                criteria.addOrder(Order.asc(key));
            } else if (value.equals("desc")) {
                criteria.addOrder(Order.desc(key));
            }
        });
        return criteria.list();
    }
}