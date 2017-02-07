package com.singh.vinay.hadlercalleverysecond;

import java.io.Serializable;

/**
 * Created by root on 31/1/17.
 */
public class ComonModel implements Serializable {
    private String id;
    private String name;
    private String lat;
    private String lon;

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }



}
