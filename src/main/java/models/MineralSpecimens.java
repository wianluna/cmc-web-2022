package models;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

@FilterDefs({
        @FilterDef(name = "objectIdFilter", parameters = @ParamDef(name = "idParam", type = "Long")),
        @FilterDef(name = "objectOriginFilter", parameters = @ParamDef(name = "originParam", type = "java.lang.String")),
        @FilterDef(name = "objectSourceFilter", parameters = @ParamDef(name = "sourceParam", type = "java.lang.String"))
})

@Filters({
        @Filter(name = "objectIdFilter", condition = "specimen_id = :idParam"),
        @Filter(name = "objectOriginFilter", condition = "possible_origin like :originParam"),
        @Filter(name = "objectSourceFilter", condition = "source like :sourceParam")
})

@Entity
@Table(name = "Mineral_Specimens")
public class MineralSpecimens {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "specimen_id")
    private Long id;

    @Column(name = "possible_origin")
    private String possibleOrigin;

    @Column(name = "location")
    private String location;

    @Column(name = "coordinates")
    private String coordinates;

    @Column(name = "source")
    private String source;

    @Column(name = "expedition_id")
    private Long expeditionId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPossibleOrigin() {
        return possibleOrigin;
    }

    public void setPossibleOrigin(String possibleOrigin) {
        this.possibleOrigin = possibleOrigin;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Long getExpeditionId() {
        return expeditionId;
    }

    public void setExpeditionId(Long expeditionId) {
        this.expeditionId = expeditionId;
    }

    public MineralSpecimens(Long id, String possibleOrigin, String location, String coordinates, String source, Long expeditionId) {
        this.id = id;
        this.possibleOrigin = possibleOrigin;
        this.location = location;
        this.coordinates = coordinates;
        this.source = source;
        this.expeditionId = expeditionId;
    }

    public MineralSpecimens() {}

    @Override
    public boolean equals(Object obj) {
        if (obj == null) { return false; }
        if (obj.getClass() != this.getClass()) { return false; }
        final MineralSpecimens other = (MineralSpecimens) obj;
        return this.id.equals(other.id) &&
                this.possibleOrigin.equals(other.possibleOrigin) &&
                this.location.equals(other.location) &&
                this.coordinates.equals(other.coordinates) &&
                this.source.equals(other.source) &&
                this.expeditionId.equals(other.expeditionId);
    }
}
