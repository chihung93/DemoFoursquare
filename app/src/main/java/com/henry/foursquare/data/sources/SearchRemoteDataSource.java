package com.henry.foursquare.data.sources;

import com.henry.foursquare.data.models.BaseResponse;
import com.henry.foursquare.data.models.Venue;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;

public class SearchRemoteDataSource implements SearchContract {

    private final SearchApi api;

    public SearchRemoteDataSource(SearchApi api) {
        this.api = api;
    }

    @Override
    public Flowable<List<Venue>> search(String query, long longitude, long latitude) {
        HashMap<String, String> params = new HashMap<>();
        params.put("query", query);
        params.put("ll", String.valueOf(latitude) + "," + String.valueOf(longitude));
        return api.search(params).flatMap((Function<BaseResponse, Flowable<List<Venue>>>) data -> Flowable.just(data.getResponse().getVenues()));
    }
}