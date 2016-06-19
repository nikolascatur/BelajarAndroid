package com.paintphobia.heri.belajarandroid;

import android.app.Application;

import com.paintphobia.heri.belajarandroid.dagger.components.BackEndComponent;
import com.paintphobia.heri.belajarandroid.dagger.components.DaggerBackEndComponent;
import com.paintphobia.heri.belajarandroid.dagger.components.DaggerServiceComponent;
import com.paintphobia.heri.belajarandroid.dagger.components.ServiceComponent;
import com.paintphobia.heri.belajarandroid.dagger.modules.AppModule;
import com.paintphobia.heri.belajarandroid.dagger.modules.BackEndModule;
import com.paintphobia.heri.belajarandroid.dagger.modules.ServiceModule;

/**
 * Created by heri on 6/18/2016.
 */
public class MyApp extends Application {

    private ServiceComponent serviceComponent;
    private BackEndComponent backEndComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        serviceComponent = DaggerServiceComponent.builder()
                .appModule(new AppModule(this))
                .serviceModule(new ServiceModule("http://muslimsalat.com/"))
                .build();

        backEndComponent = DaggerBackEndComponent.builder()
                .serviceComponent(serviceComponent)
                .backEndModule(new BackEndModule())
                .build();
    }

    public ServiceComponent getServiceComponent() {
        return serviceComponent;
    }

    public BackEndComponent getBackEndComponent() {
        return backEndComponent;
    }
}
