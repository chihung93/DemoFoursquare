package com.henry.foursquare.data.sources;

import com.henry.foursquare.data.models.BaseResponse;

import java.util.Map;

import io.reactivex.Flowable;
import retrofit2.http.FieldMap;
import retrofit2.http.GET;

public interface SearchApi {

    @GET("venues/search")
    Flowable<BaseResponse> search(@FieldMap Map<String, String> params);
}
