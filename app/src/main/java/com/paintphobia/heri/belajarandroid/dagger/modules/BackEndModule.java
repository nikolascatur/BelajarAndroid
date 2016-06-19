package com.paintphobia.heri.belajarandroid.dagger.modules;

import com.paintphobia.heri.belajarandroid.dagger.scopes.ServiceScope;
import com.paintphobia.heri.belajarandroid.services.APIService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by heri on 6/19/2016.
 */
@Module
public class BackEndModule {

    @Provides
    @ServiceScope
    public APIService providesBackEndInterface(Retrofit retrofit) {
        return retrofit.create(APIService.class);
    }

}
