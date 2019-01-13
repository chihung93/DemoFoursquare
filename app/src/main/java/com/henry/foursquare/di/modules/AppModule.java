package com.henry.foursquare.di.modules;

import android.content.Context;

import com.henry.foursquare.FoursquareApplication;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module(includes = {
        RestfulModule.class,
        RepositoryModule.class
})
public class AppModule {

    @Provides
    @Singleton
    Context provideApplicationContext(FoursquareApplication application) {
        return application.getApplicationContext();
    }
}
