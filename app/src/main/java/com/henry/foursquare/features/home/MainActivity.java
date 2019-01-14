package com.henry.foursquare.features.home;

import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.henry.foursquare.R;
import com.henry.foursquare.common.bases.BaseActivity;
import com.henry.foursquare.common.utils.LocationUtils;
import com.henry.foursquare.data.models.Venue;
import com.henry.foursquare.features.home.domain.adapters.VenuesAdapter;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

public class MainActivity extends BaseActivity implements MainContract.View {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    VenuesAdapter adapter;
    @BindView(R.id.search)
    EditText search;
    @Inject
    MainPresenter presenter;
    final PublishSubject<String> subject = PublishSubject.create();
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
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                subject.onNext(s.toString().trim());
            }
        });
        presenter.getCompositeDisposable().add(
                subject.debounce(300, TimeUnit.MILLISECONDS)
                        .subscribeOn(Schedulers.io())
                        .filter(text -> !text.isEmpty())
                        .distinctUntilChanged()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(result -> presenter.search(result, longitude, latitude), Throwable::printStackTrace));
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
            }
        }
    };
}
