package com.henry.foursquare.features.home;

import com.henry.foursquare.data.models.Venue;

import java.util.List;

public interface MainContract {
    interface View {
        void showLoading(boolean show);
        void onSuccess(List<Venue> data);
        void onFailure();
    }

    interface Presenter {
        void search(String query,double longitude,double latitude);
    }
}
