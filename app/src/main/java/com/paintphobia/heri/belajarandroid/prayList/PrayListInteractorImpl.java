package com.paintphobia.heri.belajarandroid.prayList;

import android.text.TextUtils;

/**
 * Created by heri on 6/12/2016.
 */
public class PrayListInteractorImpl implements PrayListInteractor {

    @Override
    public void submit(String location, String times, String date, boolean daylight, String method, OnSubmitListener listener) {
        if(TextUtils.isEmpty(date)) {
            listener.onDateError();
            return;
        }
        if(TextUtils.isEmpty(location)) {
            listener.onLocationError();
            return;
        }
        if(TextUtils.isEmpty(method)) {
            listener.onMethodError();
            return;
        }
        if(TextUtils.isEmpty(times)) {
            listener.onTimeError();
            return;
        }

        listener.onSuccess();
    }
}
