package entity;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import javax.persistence.*;

@FilterDef(name = "nameFilter", parameters = @ParamDef(name = "nameParam", type = "java.lang.String"))
@Filter(name = "nameFilter", condition = "fcn like :nameParam")

@Entity
@Table(name = "Mineral_Species")
public class MineralSpecies {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "species_id")
    private Long id;

    @Column(name = "species_name")
    private String species_name;

    @Column(name = "chemical_formula")
    private String chemical_formula;

    @Column(name = "origin")
    private String origin;

    @Column(name = "class_id")
    private Long class_id;

    public MineralSpecies() {}

    public MineralSpecies(Long id, String species_name, String chemical_formula, String origin, Long class_id) {
        this.id = id;
        this.species_name = species_name;
        this.chemical_formula = chemical_formula;
        this.origin = origin;
        this.class_id = class_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecies_name() {
        return species_name;
    }

    public void setSpecies_name(String species_name) {
        this.species_name = species_name;
    }

    public String getChemical_formula() {
        return chemical_formula;
    }

    public void setChemical_formula(String chemical_formula) {
        this.chemical_formula = chemical_formula;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Long getClass_id() {
        return class_id;
    }

    public void setClass_id(Long class_id) {
        this.class_id = class_id;
    }
}
