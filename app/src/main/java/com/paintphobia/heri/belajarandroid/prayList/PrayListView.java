package com.paintphobia.heri.belajarandroid.prayList;

import com.paintphobia.heri.belajarandroid.services.PrayTimesResponse;

/**
 * Created by heri on 6/11/2016.
 */
public interface PrayListView {
    void showProgress();

    void hideProgress();

    void onSuccess(PrayTimesResponse prayTimesResponse);

    void onFailure(String msg);
}
