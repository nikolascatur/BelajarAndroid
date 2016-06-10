package com.paintphobia.heri.belajarandroid.login;

import android.util.Log;

/**
 * Created by heri on 6/9/2016.
 */
public class LoginPresenterImpl implements LoginPresenter, LoginInteractor.OnLoginFinishedListener{

    private LoginView loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        this.loginInteractor = new LoginInteractorImpl();
    }


    @Override
    public void validateCredentials(String username, String password) {
        if(loginView != null) {
            loginView.showProgress();
        }

        loginInteractor.login(username, password, this);
    }

    @Override
    public void onDestroy() {
        loginView = null;
    }

    @Override
    public void onUsernameError() {
        if(loginView != null) {
            Log.d("LOGIN","onUsernameError");
            loginView.setUsernameError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onPasswordError() {
        if(loginView != null) {
            Log.d("LOGIN","onPasswordError");
            loginView.setPasswordError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onSuccess() {
        if(loginView != null) {
            loginView.navigateToMenu();
        }
    }
}
