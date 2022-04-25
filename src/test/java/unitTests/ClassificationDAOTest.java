package unitTests;

import dao.ClassificationDAO;
import models.Classification;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ClassificationDAOTest {
    private ClassificationDAO classificationDao = new ClassificationDAO();

    @Test
    void getAllClassesTest() {
        List<Classification> classesList = classificationDao.getAll(Classification.class);
        Assert.assertNotNull(classesList);
    }
}