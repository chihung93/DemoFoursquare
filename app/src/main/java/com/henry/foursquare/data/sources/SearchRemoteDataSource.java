package com.henry.foursquare.data.sources;

import com.henry.foursquare.common.utils.TimeUtils;
import com.henry.foursquare.data.models.BaseResponse;
import com.henry.foursquare.data.models.Venue;
import com.henry.foursquare.global.Constant;

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
    public Flowable<List<Venue>> search(String query, double longitude, double latitude) {
        HashMap<String, String> params = new HashMap<>();
        params.put("query", query);
        params.put("ll", String.valueOf(latitude) + "," + String.valueOf(longitude));
        params.put("client_id",Constant.CLIENT_ID);
        params.put("client_secret",Constant.CLIENT_SECRET);
        params.put("v",TimeUtils.getCurrentDay());
        return api.search(params).flatMap((Function<BaseResponse, Flowable<List<Venue>>>) data -> Flowable.just(data.getResponse().getVenues()));
    }
}