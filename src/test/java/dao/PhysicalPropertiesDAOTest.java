package dao;

import com.google.common.collect.Lists;
import models.PhysicalProperties;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PhysicalPropertiesDAOTest {
    private PhysicalPropertiesDAO physPropDAO = new PhysicalPropertiesDAO();

    @Test
    void deleteCreatePhysPropTest() {
        Long id = Long.valueOf(4);
        PhysicalProperties entity = physPropDAO.getById(PhysicalProperties.class, id);
        physPropDAO.remove(entity);
        assertNull(physPropDAO.getById(PhysicalProperties.class, id));
        physPropDAO.create(entity);
        PhysicalProperties physProp = physPropDAO.getById(PhysicalProperties.class, id);
        assertEquals(physProp, entity);
    }

    @Test
    void sortPhysPropTest() {
        List<PhysicalProperties> result = physPropDAO.sort(PhysicalProperties.class, Map.of("hardness", "asc"));
        List<PhysicalProperties> check = Lists.newArrayList(result);
        check.sort(Comparator.comparing(PhysicalProperties::getHardness));
        Assert.assertEquals(result, check);

        result = physPropDAO.sort(PhysicalProperties.class, Map.of("hardness", "desc"));
        check = Lists.newArrayList(result);
        check.sort(Comparator.comparing(PhysicalProperties::getHardness).reversed());
        Assert.assertEquals(result, check);
    }
}
