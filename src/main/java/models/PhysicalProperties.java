package models;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import javax.persistence.*;


@Entity
@Table(name = "Physical_Properties")
public class PhysicalProperties {
    @Id
    @Column(name = "species_id")
    private Long id;

    @Column(name = "lattice_type")
    private String latticeType;

    @Column(name = "hardness")
    private float hardness;

    @Column(name = "lustre")
    private String lustre;

    @Column(name = "color")
    private String color;

    @Column(name = "magnetism")
    private String magnetism;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLatticeType() {
        return latticeType;
    }

    public void setLatticeType(String latticeType) {
        this.latticeType = latticeType;
    }

    public float getHardness() {
        return hardness;
    }

    public void setHardness(float hardness) {
        this.hardness = hardness;
    }

    public String getLustre() {
        return lustre;
    }

    public void setLustre(String lustre) {
        this.lustre = lustre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMagnetism() {
        return magnetism;
    }

    public void setMagnetism(String magnetism) {
        this.magnetism = magnetism;
    }

    public PhysicalProperties() {}

    public PhysicalProperties(Long id, String latticeType, float hardness, String lustre, String color, String magnetism) {
        this.id = id;
        this.latticeType = latticeType;
        this.hardness = hardness;
        this.lustre = lustre;
        this.color = color;
        this.magnetism = magnetism;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) { return false; }
        if (obj.getClass() != this.getClass()) { return false; }
        final PhysicalProperties other = (PhysicalProperties) obj;
        return this.id.equals(other.id) &&
                this.latticeType.equals(other.latticeType) &&
                this.hardness == other.hardness &&
                this.lustre.equals(other.lustre) &&
                this.color.equals(other.color) &&
                this.magnetism.equals(other.magnetism);
    }
}
