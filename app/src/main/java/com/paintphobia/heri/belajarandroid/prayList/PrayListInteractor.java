package com.paintphobia.heri.belajarandroid.prayList;

/**
 * Created by heri on 6/12/2016.
 */
public interface PrayListInteractor {

    interface OnSubmitListener {
        void onDateError();

        void onLocationError();

        void onMethodError();

        void onTimeError();

        void onSuccess();
    }

    void submit(String location, String times, String date, boolean daylight, String method, OnSubmitListener listener);
}
