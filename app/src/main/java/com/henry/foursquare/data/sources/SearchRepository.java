package com.henry.foursquare.data.sources;

import com.henry.foursquare.data.models.Venue;

import java.util.List;

import io.reactivex.Flowable;

public class SearchRepository implements SearchContract {

    private final SearchContract remote;

    public SearchRepository(SearchContract remote) {
        this.remote = remote;
    }

    @Override
    public Flowable<List<Venue>> search(String query, long longitude, long latitude) {
        return remote.search(query,longitude,latitude);
    }
}