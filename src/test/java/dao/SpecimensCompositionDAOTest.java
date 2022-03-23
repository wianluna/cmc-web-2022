package dao;

import models.SpecimensComposition;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpecimensCompositionDAOTest {
    private SpecimensCompositionDAO compositionDao = new SpecimensCompositionDAO();

    @Test
    void getPercentageByIdTest() {
        Long id1 = Long.valueOf(5);
        Long id2 = Long.valueOf(3);
        SpecimensComposition composition = compositionDao.getById(id1, id2);
        assertEquals(composition.getPercentage(), 76.5);
    }
}
