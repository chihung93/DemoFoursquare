package com.henry.foursquare.features.home;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.henry.foursquare.R;
import com.henry.foursquare.common.bases.BaseActivity;
import com.henry.foursquare.data.sources.SearchRemoteDataSource;
import com.henry.foursquare.data.sources.SearchRepository;
import com.henry.foursquare.features.home.domain.adapters.VenuesAdapter;

import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    VenuesAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        adapter = new VenuesAdapter();
        recyclerView.setAdapter(adapter);
    }

    public static void start(Activity context){
        Intent intent = new Intent(context,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
        context.finish();
    }
}
