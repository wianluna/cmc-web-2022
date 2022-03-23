package models;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "Mineral_Species")
public class MineralSpecies {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "species_id")
    private Long id;

    @Column(name = "species_name")
    private String speciesName;

    @Column(name = "chemical_formula")
    private String chemicalFormula;

    @Column(name = "origin")
    private String origin;

    @Column(name = "class_id")
    private Long classId;

    public MineralSpecies() {}

    public MineralSpecies(Long id, String speciesName, String chemicalFormula, String origin, Long classId) {
        this.id = id;
        this.speciesName = speciesName;
        this.chemicalFormula = chemicalFormula;
        this.origin = origin;
        this.classId = classId;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) { return false; }
        if (obj.getClass() != this.getClass()) { return false; }
        final MineralSpecies other = (MineralSpecies) obj;
        return this.id.equals(other.id) &&
                this.speciesName.equals(other.speciesName) &&
                this.chemicalFormula.equals(other.chemicalFormula) &&
                this.origin.equals(other.origin) &&
                this.classId.equals(other.classId);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpeciesName() {
        return speciesName;
    }

    public void setSpeciesName(String species_name) {
        this.speciesName = species_name;
    }

    public String getChemicalFormula() {
        return chemicalFormula;
    }

    public void setChemicalFormula(String chemical_formula) {
        this.chemicalFormula = chemical_formula;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long class_id) {
        this.classId = class_id;
    }
}
