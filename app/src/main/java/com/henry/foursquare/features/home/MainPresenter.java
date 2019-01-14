package com.henry.foursquare.features.home;

import com.henry.foursquare.data.sources.SearchRepository;


import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

public class MainPresenter implements MainContract.Presenter {

    private final SearchRepository searchRepository;
    private  MainContract.View view;
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();


    public MainPresenter(SearchRepository searchRepository) {
        this.searchRepository = searchRepository;
    }

    @Override
    public void search(String query, double longitude, double latitude) {
        view.showLoading(true);
        compositeDisposable.add(searchRepository.search(query,longitude,latitude).
        subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(view::onSuccess, throwable -> view.onFailure()));
    }

    public void clearAll(){
        compositeDisposable.clear();
    }

    public void setView(MainContract.View view) {
        this.view = view;
    }

    public CompositeDisposable getCompositeDisposable() {
        return compositeDisposable;
    }
}
