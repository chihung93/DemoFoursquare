package com.henry.foursquare.features.home;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ProgressBar;

import com.henry.foursquare.R;
import com.henry.foursquare.common.bases.BaseActivity;
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

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        presenter.setView(this);
        adapter = new VenuesAdapter();
        recyclerView.setAdapter(adapter);
        presenter.search("Subway", 40.7484, -73.9857);
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
}
