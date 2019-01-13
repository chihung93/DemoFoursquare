package com.henry.foursquare.features.home;

import android.content.Context;
import android.content.Intent;

import com.henry.foursquare.R;
import com.henry.foursquare.common.bases.BaseActivity;
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

    public static void start(Context context){
        Intent intent = new Intent(context,MainActivity.class);
        context.startActivity(intent);
    }
}
