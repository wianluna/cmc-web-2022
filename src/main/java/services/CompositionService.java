package services;

import models.SpecimensComposition;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.SessionUtilImpl;

import java.util.List;

public class CompositionService extends SessionUtilImpl {
    public List<SpecimensComposition> getBySpecimenId(Long specimenId) {
        String sql = "SELECT * FROM specimens_composition WHERE specimen_id = :specimenId";

        Session session = openSession();
        Query query = session.createNativeQuery(sql).addEntity(SpecimensComposition.class);

        query.setParameter("specimenId", specimenId);

        List<SpecimensComposition> res = (List<SpecimensComposition>) query.getResultList();

        closeSession();
        return res;
    }
}
