package com.paintphobia.heri.belajarandroid.login;

import android.os.Handler;
import android.text.TextUtils;

/**
 * Created by heri on 6/9/2016.
 */
public class LoginInteractorImpl implements LoginInteractor {

    @Override
    public void login(final String username, final String password, final OnLoginFinishedListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean isError = false;
                if(TextUtils.isEmpty(username)){
                    listener.onUsernameError();
                    isError = true;
                }
                if(TextUtils.isEmpty(password)){
                    listener.onPasswordError();
                    isError = true;
                }
                if(!isError){
                    listener.onSuccess();
                }
            }
        }, 10);
    }
}
