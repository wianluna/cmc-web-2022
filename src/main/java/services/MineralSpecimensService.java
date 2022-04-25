package services;

import models.MineralSpecimens;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.SessionUtilImpl;

import java.util.List;

public class MineralSpecimensService extends SessionUtilImpl {
    public List<MineralSpecimens> getBySourceAndOrigin(String source, String possibleOrigin) {
        String sql = "SELECT * FROM mineral_specimens";
        if (source != null & possibleOrigin != null) {
            sql = "SELECT * FROM mineral_specimens WHERE source = :source and possible_origin = :possibleOrigin";
        } else if (source != null) {
            sql = "SELECT * FROM mineral_specimens WHERE source = :source";
        } else if (possibleOrigin != null) {
            sql = "SELECT * FROM mineral_specimens WHERE possible_origin = :possibleOrigin";
        }

        Session session = openSession();
        Query query = session.createNativeQuery(sql).addEntity(MineralSpecimens.class);

        if (source != null & possibleOrigin != null) {
            query.setParameter("source", source);
            query.setParameter("possibleOrigin", possibleOrigin);
        } else if (source != null) {
            query.setParameter("source", source);
        } else if (possibleOrigin != null) {
            query.setParameter("possibleOrigin", possibleOrigin);
        }

        List<MineralSpecimens> res = (List<MineralSpecimens>) query.getResultList();
        closeSession();
        return res;
    }

    public List<MineralSpecimens> getByExpedition(Long expeditionId) {
        String sql = "SELECT * FROM mineral_specimens";
        if (expeditionId != null) {
            sql = "SELECT * FROM mineral_specimens WHERE expedition_id = :expeditionId";
        }

        Session session = openSession();
        Query query = session.createNativeQuery(sql).addEntity(MineralSpecimens.class);

        if (expeditionId != null) {
            query.setParameter("expeditionId", expeditionId);
        }

        List<MineralSpecimens> res = (List<MineralSpecimens>) query.getResultList();
        closeSession();
        return res;
    }

    public List<MineralSpecimens> getBySpecies(Long speciesId) {
        String sql = "SELECT * FROM mineral_specimens";
        if (speciesId != null) {
            sql = "SELECT * FROM mineral_specimens INNER JOIN specimens_composition ON mineral_specimens.specimen_id = specimens_composition.specimen_id  WHERE species_id = :speciesId";
        }

        Session session = openSession();
        Query query = session.createNativeQuery(sql).addEntity(MineralSpecimens.class);

        if (speciesId != null) {
            query.setParameter("speciesId", speciesId);
        }

        List<MineralSpecimens> res = (List<MineralSpecimens>) query.getResultList();
        closeSession();
        return res;
    }
}
