package com.henry.foursquare.di;

import com.henry.foursquare.features.home.MainActivity;
import com.henry.foursquare.features.home.MainActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = {MainActivityModule.class})
    abstract MainActivity bindMainActivity();
}
