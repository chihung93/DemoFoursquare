package com.henry.foursquare;

import android.content.Context;

import com.henry.foursquare.di.DaggerAppComponent;

import androidx.multidex.MultiDex;
import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;
import timber.log.Timber;
public class FoursquareApplication extends DaggerApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().create(this);
    }

    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}