package com.henry.foursquare.features.home;

import com.henry.foursquare.data.sources.SearchRepository;
import com.henry.foursquare.di.modules.ViewModelFactory;

import androidx.lifecycle.ViewModelProvider;
import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {

    @Provides
    MainPresenter provideMainPresenter(SearchRepository searchRepository) {
        return new MainPresenter(searchRepository);
    }

    @Provides
    ViewModelProvider.Factory providePresenterFactory(MainPresenter viewModel) {
        return new ViewModelFactory<>(viewModel);
    }
}
