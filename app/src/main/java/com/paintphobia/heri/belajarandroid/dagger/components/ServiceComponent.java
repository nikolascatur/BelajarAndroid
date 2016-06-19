package com.paintphobia.heri.belajarandroid.dagger.components;

import android.content.SharedPreferences;

import com.paintphobia.heri.belajarandroid.dagger.modules.AppModule;
import com.paintphobia.heri.belajarandroid.dagger.modules.ServiceModule;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by heri on 6/19/2016.
 */
@Singleton
@Component(modules = {
        AppModule.class,
        ServiceModule.class
})
public interface ServiceComponent {

    Retrofit retrofit();
    OkHttpClient okHttpClient();
    SharedPreferences sharedPreferences();
}
