package edu.mypet.domain;


import javax.persistence.*;

@Entity
@Table(name="areas")
public class AreaFuller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="area_id")
    private Long areaId;
    @Column(name="area_code")
    private String areaCode;
    @Column(name="area_name")
    private String areaName;

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    @Override
    public String toString() {
        return "AreaFuller{" +
                "areaId=" + areaId +
                ", areaCode='" + areaCode + '\'' +
                ", areaName='" + areaName + '\'' +
                '}';
    }
}
