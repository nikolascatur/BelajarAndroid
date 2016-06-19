package com.paintphobia.heri.belajarandroid.dagger.components;

import com.paintphobia.heri.belajarandroid.dagger.modules.BackEndModule;
import com.paintphobia.heri.belajarandroid.dagger.scopes.ServiceScope;
import com.paintphobia.heri.belajarandroid.prayList.PrayListActivity;

import dagger.Component;

/**
 * Created by heri on 6/19/2016.
 */
@ServiceScope
@Component(
        dependencies = ServiceComponent.class,
        modules = BackEndModule.class
)
public interface BackEndComponent {

    void inject(PrayListActivity prayListActivity);

}
