package edu.mypet.domain;

public class Response {
    private String area_name;
    private String district_name;

    public String getArea_name() {
        return area_name;
    }

    public void setArea_name(String area_name) {
        this.area_name = area_name;
    }

    public String getDistrict_name() {
        return district_name;
    }

    public void setDistrict_name(String district_name) {
        this.district_name = district_name;
    }

    @Override
    public String toString() {
        return "Response{" +
                "area_name='" + area_name + '\'' +
                ", district_name='" + district_name + '\'' +
                '}';
    }
}
