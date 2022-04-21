package services;

import models.MineralSpecies;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.SessionUtilImpl;

import java.util.List;

public class MineralSpeciesServices extends SessionUtilImpl {
    public List<MineralSpecies> getBySpeciesName(String speciesName) {
        String sql = "SELECT * FROM mineral_species WHERE species_name like :speciesName";

        Session session = openSession();
        Query query = session.createNativeQuery(sql).addEntity(MineralSpecies.class);

        query.setParameter("speciesName", speciesName);

        List<MineralSpecies> res = (List<MineralSpecies>) query.getResultList();
        closeSession();
        return res;
    }
}
