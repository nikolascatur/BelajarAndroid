package com.paintphobia.heri.belajarandroid.services;

/**
 * Created by heri on 6/10/2016.
 */
public class PrayTimes {
    String date;
    boolean daylight;
    String location;
    String method;
    String times;

    public void setDate(String pDate) {
        this.date = pDate;
    }

    public void setDaylight(boolean pDaylight) {
        this.daylight = pDaylight;
    }

    public void setLocation(String pLocation) {
        this.location = pLocation;
    }

    public void setMethod(String pMethod) {
        this.method = pMethod;
    }

    public void setTimes(String pTimes) {
        this.times = pTimes;
    }

    public String getDate() {
        return this.date;
    }

    public boolean getDaylight() {
        return this.daylight;
    }

    public String getLocation() {
        return this.location;
    }

    public String getMethod() {
        return this.method;
    }

    public String getTimes() {
        return this.times;
    }
}
