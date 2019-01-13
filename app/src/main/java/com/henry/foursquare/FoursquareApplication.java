package com.henry.foursquare;

import android.app.Application;

import timber.log.Timber;
public class FoursquareApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }
}
