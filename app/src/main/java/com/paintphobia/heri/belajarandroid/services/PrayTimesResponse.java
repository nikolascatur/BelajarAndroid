package com.paintphobia.heri.belajarandroid.services;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by heri on 6/10/2016.
 */
public class PrayTimesResponse {
    private String title;
    private String query;
    private String map_image;
    private String sealevel;
    private String qibla_direction;
    private String latitude;
    private String longitude;
    private List<PrayTimes> items = new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getMap_image() {
        return map_image;
    }

    public void setMap_image(String map_image) {
        this.map_image = map_image;
    }

    public String getSealevel() {
        return sealevel;
    }

    public void setSealevel(String sealevel) {
        this.sealevel = sealevel;
    }

    public String getQibla_direction() {
        return qibla_direction;
    }

    public void setQibla_direction(String qibla_direction) {
        this.qibla_direction = qibla_direction;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public List<PrayTimes> getItems() {
        return items;
    }

    public void setItems(List<PrayTimes> items) {
        this.items = items;
    }
}
