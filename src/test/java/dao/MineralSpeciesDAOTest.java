package dao;

import models.MineralSpecies;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class MineralSpeciesDAOTest {

    private MineralSpeciesDAO mineralDAO = new MineralSpeciesDAO();

//    @Test
//    void getMineralSpeciesByIdTest() {
//        Long id = Long.valueOf(4);
//        MineralSpecies mineral = mineralDAO.getById(MineralSpecies.class, id);
//        Assert.assertEquals(mineral.getSpeciesName(), "опал");
//    }

//    @Test
//    void updateTest() {
//        MineralSpecies entity = new MineralSpecies(1L, "малахит",
//                "Cu2CO3(OH)2", "осадочное", 7L);
//        mineralDAO.update(entity);
//        MineralSpecies mineral = mineralDAO.getById(MineralSpecies.class, 1L);
//        assertEquals(mineral, entity);
//    }

//    @Test
//    void filterTest() {
//        List<MineralSpecies> result = MineralSpeciesDAO.filter(Map.of("nameFilter",
//                Lists.newArrayList("%Анастасия%")), MineralSpecies.class);
//        result.forEach(MineralSpecies -> Assert.assertTrue(MineralSpecies.getName().contains("Анастасия")));
//    }
//
//    @Test
//    void sortTest() {
//        List<MineralSpecies> result = MineralSpeciesDAO.sort(Map.of("name", "asc"), MineralSpecies.class);
//        List<MineralSpecies> check = Lists.newArrayList(result);
//        check.sort(Comparator.comparing(MineralSpecies::getName));
//        Assert.assertEquals(result, check);
//
//        result = MineralSpeciesDAO.sort(Map.of("name", "desc"), MineralSpecies.class);
//        check = Lists.newArrayList(result);
//        check.sort(Comparator.comparing(MineralSpecies::getName).reversed());
//        Assert.assertEquals(result, check);
//    }
}
