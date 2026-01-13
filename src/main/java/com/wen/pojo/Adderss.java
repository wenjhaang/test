package com.wen.pojo;

public class Adderss {
    private String province;
    private String city;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Adderss{" +
                "province='" + province + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
