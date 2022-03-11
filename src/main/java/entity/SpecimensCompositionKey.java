package entity;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import java.io.Serializable;

@FilterDef(name = "nameFilter", parameters = @ParamDef(name = "nameParam", type = "java.lang.String"))
@Filter(name = "nameFilter", condition = "fcn like :nameParam")

public class SpecimensCompositionKey implements Serializable {
    private Long specimenId;
    private Long speciesId;

    public SpecimensCompositionKey(Long specimenId, Long speciesId) {
        this.specimenId = specimenId;
        this.speciesId = speciesId;
    }
}
