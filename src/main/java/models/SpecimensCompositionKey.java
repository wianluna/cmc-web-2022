package models;

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

    public SpecimensCompositionKey() {
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) { return false; }
        if (obj.getClass() != this.getClass()) { return false; }
        final SpecimensCompositionKey other = (SpecimensCompositionKey) obj;
        return (this.speciesId.equals(other.speciesId)) &&
                (this.specimenId.equals(other.specimenId));
    }
}
