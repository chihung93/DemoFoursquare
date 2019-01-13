package com.henry.foursquare.data.sources;

import com.henry.foursquare.data.models.Venue;

import java.util.List;

import io.reactivex.Flowable;

public interface SearchContract {
    Flowable<List<Venue>> search(String query, long longitude, long latitude);
}
