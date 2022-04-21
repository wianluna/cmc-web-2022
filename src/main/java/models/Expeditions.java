package models;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.sql.Date;

@FilterDefs({
        @FilterDef(name = "timeFilterStart",
                parameters = {
                        @ParamDef(name = "minParam", type = "java.sql.Date"),
                        @ParamDef(name = "maxParam", type = "java.sql.Date")
                }),
        @FilterDef(name = "timeFilterEnd",
                parameters = {
                        @ParamDef(name = "minParam", type = "java.sql.Date"),
                        @ParamDef(name = "maxParam", type = "java.sql.Date")
                })
})

@Filters({
        @Filter(name = "timeFilterStart",
                condition = "date_start between :minParam and :maxParam"),
        @Filter(name = "timeFilterEnd",
                condition = "date_end between :minParam and :maxParam")
})

@Entity
@Table(name = "Expeditions")
public class Expeditions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "expedition_id")
    private Long id;

    @Column(name = "date_start")
    private Date dateStart;

    @Column(name = "date_end")
    private Date dateEnd;

    @Column(name = "members")
    private String members;

    @Column(name = "description")
    private String description;

    public Expeditions() {
    }

    public Expeditions(Date dateStart, Date dateEnd, String members, String description) {
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.members = members;
        this.description = description;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) { return false; }
        if (obj.getClass() != this.getClass()) { return false; }
        final Expeditions other = (Expeditions) obj;
        return this.id.equals(other.id) &&
                this.dateStart.equals(other.dateStart) &&
                this.dateEnd.equals(other.dateEnd) &&
                this.members.equals(other.members) &&
                this.description.equals(other.description);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getMembers() {
        return members;
    }

    public void setMembers(String members) {
        this.members = members;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
