package utils;

import models.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

public class HibernateUtil {

    private static SessionFactory sessionFactory = null;
    static {
        try {
            sessionFactory = new Configuration()
                    .configure()
                    .addAnnotatedClass(Classification.class)
                    .addAnnotatedClass(MineralSpecies.class)
                    .addAnnotatedClass(PhysicalProperties.class)
                    .addAnnotatedClass(Expeditions.class)
                    .addAnnotatedClass(MineralSpecimens.class)
                    .addAnnotatedClass(SpecimensComposition.class)
                    .buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
