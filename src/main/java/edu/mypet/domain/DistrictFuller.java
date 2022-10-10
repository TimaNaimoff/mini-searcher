package edu.mypet.domain;


import javax.persistence.*;

@Entity
@Table(name="districts")
public class DistrictFuller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="district_id")
    private Long districtId;
    @Column(name="district_code")
    private String districtCode;
    @Column(name="district_name")
    private String districtName;

    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    @Override
    public String toString() {
        return "DistrictFuller{" +
                "districtId=" + districtId +
                ", districtCode='" + districtCode + '\'' +
                ", districtName='" + districtName + '\'' +
                '}';
    }
}
