package com.paintphobia.heri.belajarandroid.services;

import java.io.Serializable;

/**
 * Created by heri on 6/10/2016.
 */
public class PrayTimes implements Serializable{
    String date_for;
    String fajr;
    String shurooq;
    String dhuhr;
    String asr;
    String maghrib;
    String isha;

    public String getDate_for() {
        return this.date_for;
    }

    public void setDate_for(String date_for) {
        this.date_for = date_for;
    }

    public void setFajr(String fajr) {
        this.fajr = fajr;
    }

    public void setShurooq(String shurooq) {
        this.shurooq = shurooq;
    }

    public void setDhuhr(String dhuhr) {
        this.dhuhr = dhuhr;
    }

    public void setAsr(String asr) {
        this.asr = asr;
    }

    public void setMaghrib(String maghrib) {
        this.maghrib = maghrib;
    }

    public void setIsha(String isha) {
        this.isha = isha;
    }

    public String getFajr() {
        return fajr;
    }

    public String getShurooq() {
        return shurooq;
    }

    public String getDhuhr() {
        return dhuhr;
    }

    public String getAsr() {
        return asr;
    }

    public String getMaghrib() {
        return maghrib;
    }

    public String getIsha() {
        return isha;
    }
}
