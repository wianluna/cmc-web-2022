package models;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import javax.persistence.*;

@FilterDef(name = "nameFilter", parameters = @ParamDef(name = "nameParam", type = "java.lang.String"))
@Filter(name = "nameFilter", condition = "fcn like :nameParam")

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
}
