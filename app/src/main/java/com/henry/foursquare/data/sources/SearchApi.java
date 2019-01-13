package com.henry.foursquare.data.sources;

import com.henry.foursquare.data.models.BaseResponse;

import java.util.Map;

import io.reactivex.Flowable;

import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface SearchApi {

    @GET("venues/search")
    Flowable<BaseResponse> search(@QueryMap Map<String, String> params);
}
