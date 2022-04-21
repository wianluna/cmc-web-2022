package models;

import javax.persistence.*;

@Entity @IdClass(SpecimensCompositionKey.class)
@Table(name = "Specimens_Composition")
public class SpecimensComposition {
    @Id
    @Column(name = "specimen_id")
    private Long specimenId;

    @Id
    @Column(name = "species_id")
    private Long speciesId;

    @Column(name = "species_name")
    private String speciesName;

    @Column(name = "inclusion_type")
    private String inclusionType;

    @Column(name = "percentage")
    private float percentage;

    public void setSpeciesName(String speciesName) {
        this.speciesName = speciesName;
    }

    public String getSpeciesName() {
        return speciesName;
    }

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

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    public SpecimensComposition(Long specimenId, Long speciesId) {
        this.specimenId = specimenId;
        this.speciesId = speciesId;
    }

    public SpecimensComposition() {
    }

    public SpecimensComposition(Long specimenId, Long speciesId, String speciesName, String inclusionType, float percentage) {
        this.specimenId = specimenId;
        this.speciesId = speciesId;
        this.speciesName = speciesName;
        this.inclusionType = inclusionType;
        this.percentage = percentage;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) { return false; }
        if (obj.getClass() != this.getClass()) { return false; }
        final SpecimensComposition other = (SpecimensComposition) obj;
        return this.specimenId.equals(other.specimenId) &&
                this.speciesId.equals(other.speciesId) &&
                this.inclusionType == other.inclusionType &&
                this.percentage == other.percentage;
    }
}
