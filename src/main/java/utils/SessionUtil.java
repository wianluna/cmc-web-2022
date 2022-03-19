package utils;

import org.hibernate.Session;
import org.hibernate.Transaction;

public interface SessionUtil {
    public Session getSession();
    public Transaction getTransaction();

    public Session openSession();

    public Session openTransactionSession();

    public void closeSession();

    public void closeTransactionSession();
}