package models;

public class Composition {
    public String speciesName;
    public String inclusionType;
    public float percentage;

    public void setSpeciesName(String speciesName) {
        this.speciesName = speciesName;
    }

    public void setInclusionType(String inclusionType) {
        this.inclusionType = inclusionType;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    public String getSpeciesName() {
        return speciesName;
    }

    public String getInclusionType() {
        return inclusionType;
    }

    public float getPercentage() {
        return percentage;
    }

    public Composition(String speciesName, String inclusionType, float percentage) {
        this.speciesName = speciesName;
        this.inclusionType = inclusionType;
        this.percentage = percentage;
    }
}
