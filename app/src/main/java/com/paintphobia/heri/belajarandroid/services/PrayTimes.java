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


    public String getDate() {
        return this.date_for;
    }
    public String getFajr() {
        return this.fajr;
    }
    public String getShurooq() {
        return this.shurooq;
    }

    public String getDhuhr() {
        return this.dhuhr;
    }
    public String getAsr() {
        return this.asr;
    }
    public String getMaghrib() {
        return this.maghrib;
    }
    public String getIsha() {
        return this.isha;
    }

}
