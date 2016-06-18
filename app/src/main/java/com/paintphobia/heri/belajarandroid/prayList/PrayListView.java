package com.paintphobia.heri.belajarandroid.prayList;

import com.paintphobia.heri.belajarandroid.services.PrayTimesResponse;
import com.paintphobia.heri.belajarandroid.utils.NetworkError;

/**
 * Created by heri on 6/11/2016.
 */
public interface PrayListView {
    void showProgress();

    void hideProgress();

    void onSuccess(PrayTimesResponse prayTimesResponse);

    void onFailure(NetworkError networkError);

    void showToast(String msg);
}
