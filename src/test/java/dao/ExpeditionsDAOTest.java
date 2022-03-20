package dao;

import models.Expeditions;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ExpeditionsDAOTest {
    private ExpeditionsDAO expeditionDao = new ExpeditionsDAO();

    @Test
    void getExpeditionByIdTest() {
        Long id = Long.valueOf(4);
        Expeditions expedition = expeditionDao.getById(Expeditions.class, id);
        assertEquals(expedition.getId(), 4);
    }
}
