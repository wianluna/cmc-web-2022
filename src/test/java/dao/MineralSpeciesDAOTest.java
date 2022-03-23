package dao;

import models.MineralSpecies;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class MineralSpeciesDAOTest {

    private MineralSpeciesDAO mineralDAO = new MineralSpeciesDAO();

    @Test
    void getMineralSpeciesByIdTest() {
        Long id = Long.valueOf(4);
        MineralSpecies mineral = mineralDAO.getById(MineralSpecies.class, id);
        Assert.assertEquals(mineral.getSpeciesName(), "опал");
    }

    @Test
    void updateTest() {
        MineralSpecies entity = new MineralSpecies(1L, "малахит",
                "Cu2CO3(OH)2", "осадочное", 12L);
        mineralDAO.update(entity);
        MineralSpecies mineral = mineralDAO.getById(MineralSpecies.class, 1L);
        assertEquals(mineral, entity);
    }
}
