package com.henry.foursquare.di;

import com.henry.foursquare.FoursquareApplication;
import com.henry.foursquare.di.modules.AppModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        AppModule.class,
        ActivityBuilder.class
})
public interface AppComponent extends AndroidInjector<FoursquareApplication> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<FoursquareApplication> {
    }
}
