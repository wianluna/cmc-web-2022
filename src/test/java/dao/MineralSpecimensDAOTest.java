package dao;

import models.MineralSpecimens;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

public class MineralSpecimensDAOTest {
    private MineralSpecimensDAO objectDAO = new MineralSpecimensDAO();

    @Test
    void deleteSpecimenTest() {
        Long id = Long.valueOf(4);
        MineralSpecimens entity = objectDAO.getById(MineralSpecimens.class, id);
        objectDAO.remove(entity);
        assertNull(objectDAO.getById(MineralSpecimens.class, id));
    }
}
