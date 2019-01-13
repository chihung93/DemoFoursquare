package com.henry.foursquare.di.modules;

import com.henry.foursquare.data.sources.SearchApi;
import com.henry.foursquare.data.sources.SearchRemoteDataSource;
import com.henry.foursquare.data.sources.SearchRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {
    @Provides
    @Singleton
    SearchRepository provideUserDataRepository(SearchApi api) {
        return new SearchRepository(new SearchRemoteDataSource(api));
    }
}
