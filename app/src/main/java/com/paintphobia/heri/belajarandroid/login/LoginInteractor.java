package com.paintphobia.heri.belajarandroid.login;

/**
 * Created by heri on 6/9/2016.
 */
public interface LoginInteractor {

    interface OnLoginFinishedListener {
        void onUsernameError();

        void onPasswordError();

        void onSuccess();
    }

    void login(String username, String password, OnLoginFinishedListener listener);

}
