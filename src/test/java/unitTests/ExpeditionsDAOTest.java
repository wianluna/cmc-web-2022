package unitTests;

import com.google.common.collect.Lists;
import dao.ExpeditionsDAO;
import models.Expeditions;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ExpeditionsDAOTest {
    private ExpeditionsDAO expeditionDao = new ExpeditionsDAO();

    @Test
    void getExpeditionByIdTest() {
        Long id = Long.valueOf(2);
        Expeditions expedition = expeditionDao.getById(Expeditions.class, id);
        assertEquals(expedition.getDateStart(), Date.valueOf("2008-07-21"));
    }

    @Test
    void filterTest() {
        List<Expeditions> result = expeditionDao.filter(Expeditions.class, Map.of("timeFilterStart",
                Lists.newArrayList(Date.valueOf("2001-01-01"), Date.valueOf("2010-01-01"))));
        result.forEach(Expeditions -> Assert.assertTrue(Expeditions.getDateStart().after(Date.valueOf("2001-01-01"))));
        result.forEach(Expeditions -> Assert.assertTrue(Expeditions.getDateEnd().before(Date.valueOf("2001-01-01"))));
    }
}
