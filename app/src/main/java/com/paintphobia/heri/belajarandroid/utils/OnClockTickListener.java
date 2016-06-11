package com.paintphobia.heri.belajarandroid.utils;

import android.text.format.Time;

/**
 * Created by aditya on 28/05/2016.
 */
public interface OnClockTickListener {
    public void OnSecondTick(Time currentTime);
    public void OnMinuteTick(Time currentTime);
}
