package com.henry.foursquare.features.home;

import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.view.View;
import android.widget.ProgressBar;

import com.henry.foursquare.R;
import com.henry.foursquare.common.bases.BaseActivity;
import com.henry.foursquare.common.utils.LocationUtils;
import com.henry.foursquare.data.models.Venue;
import com.henry.foursquare.features.home.domain.adapters.VenuesAdapter;

import java.util.List;

import javax.inject.Inject;

import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

public class MainActivity extends BaseActivity implements MainContract.View {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    VenuesAdapter adapter;

    @Inject
    MainPresenter presenter;

    double longitude, latitude;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        presenter.setView(this);
        adapter = new VenuesAdapter();
        recyclerView.setAdapter(adapter);

        LocationUtils locationUtils = new LocationUtils();
        locationUtils.getLocation(this, locationResult);
    }

    public static void start(Activity context) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
        context.finish();
    }

    @Override
    public void showLoading(boolean show) {
        progressBar.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @Override
    public void onSuccess(List<Venue> data) {
        adapter.initData(data);
        showLoading(false);
    }

    @Override
    public void onFailure() {
        showLoading(false);
    }

    @Override
    public void onDestroy() {
        if (presenter != null) {
            presenter.clearAll();
        }
        super.onDestroy();
    }

    LocationUtils.LocationResult locationResult = new LocationUtils.LocationResult() {
        @Override
        public void gotLocation(Location location) {
            //Got the location!
            if (location != null && longitude != location.getLongitude() && latitude != location.getLatitude()) {
                longitude = location.getLongitude();
                latitude = location.getLatitude();
                presenter.search("Subway", longitude, latitude);
            }
        }
    };
}
