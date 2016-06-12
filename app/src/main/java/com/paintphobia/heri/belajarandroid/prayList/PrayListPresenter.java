package com.paintphobia.heri.belajarandroid.prayList;

/**
 * Created by heri on 6/11/2016.
 */
public interface PrayListPresenter {

    void submitRequest(String location, String times, String date, boolean daylight, String method);

    void onDestroy();
}
