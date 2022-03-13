package models;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import javax.persistence.*;

@FilterDef(name = "nameFilter", parameters = @ParamDef(name = "nameParam", type = "java.lang.String"))
@Filter(name = "nameFilter", condition = "fcn like :nameParam")

@Entity
@Table(name = "Classification")
public class Classification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "class_id")
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "class")
    private String class_;

    @Column(name = "subclass")
    private String subclass;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getClass_() {
        return class_;
    }

    public void setClass_(String class_) {
        this.class_ = class_;
    }

    public String getSubclass() {
        return subclass;
    }

    public void setSubclass(String subclass) {
        this.subclass = subclass;
    }

    public Classification(Long id, String type, String class_, String subclass) {
        this.id = id;
        this.type = type;
        this.class_ = class_;
        this.subclass = subclass;
    }

    public Classification() {}

    @Override
    public boolean equals(Object obj) {
        if (obj == null) { return false; }
        if (obj.getClass() != this.getClass()) { return false; }
        final Classification other = (Classification) obj;
        return this.type.equals(other.type) &&
                this.class_.equals(other.class_) &&
                this.subclass.equals(other.subclass);
    }
}
