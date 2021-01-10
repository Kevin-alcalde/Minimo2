package edu.upc.dsa.minimo2entregable.models;

import java.io.Serializable;

public class Address implements Serializable {

    private String country;
    private String city;
    private Double longitude;
    private Double latitude;

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Double getLatitude() {
        return latitude;
    }
}
