package com.singh.vinay.hadlercalleverysecond;

import java.io.Serializable;

/**
 * Created by root on 31/1/17.
 */
public class LatLongModel implements Serializable{
    private  String lat;
    private  String log;
    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }


}
