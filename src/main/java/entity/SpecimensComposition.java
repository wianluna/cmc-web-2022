package entity;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import javax.persistence.*;
import java.io.Serializable;

@Entity @IdClass(SpecimensCompositionKey.class)
@Table(name = "Specimens_Composition")
public class SpecimensComposition {
    @Id
    @Column(name = "specimen_id")
    private Long specimenId;

    @Id
    @Column(name = "species_id")
    private Long speciesId;

    @Column(name = "inclusion_type")
    private String inclusionType;

    @Column(name = "percentage")
    private String percentage;

    public Long getSpecimenId() {
        return specimenId;
    }

    public void setSpecimenId(Long specimenId) {
        this.specimenId = specimenId;
    }

    public Long getSpeciesId() {
        return speciesId;
    }

    public void setSpeciesId(Long speciesId) {
        this.speciesId = speciesId;
    }

    public String getInclusionType() {
        return inclusionType;
    }

    public void setInclusionType(String inclusionType) {
        this.inclusionType = inclusionType;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    public SpecimensComposition(Long specimenId, Long speciesId) {
        this.specimenId = specimenId;
        this.speciesId = speciesId;
    }

    public SpecimensComposition() {
    }

    public SpecimensComposition(Long specimenId, Long speciesId, String inclusionType, String percentage) {
        this.specimenId = specimenId;
        this.speciesId = speciesId;
        this.inclusionType = inclusionType;
        this.percentage = percentage;
    }
}
