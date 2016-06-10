package com.paintphobia.heri.belajarandroid.login;

/**
 * Created by heri on 6/9/2016.
 */
public interface LoginPresenter {
    void validateCredentials(String username, String password);

    void onDestroy();
}
