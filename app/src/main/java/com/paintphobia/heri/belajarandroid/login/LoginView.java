package com.paintphobia.heri.belajarandroid.login;

/**
 * Created by heri on 6/9/2016.
 */
public interface LoginView {
    void showProgress();

    void hideProgress();

    void setUsernameError();

    void setPasswordError();

    void navigateToMenu();
}
