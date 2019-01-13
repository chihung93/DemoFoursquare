package com.henry.foursquare.features.home.domain.holders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.henry.foursquare.R;
import com.henry.foursquare.data.models.Venue;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class VenueHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.address)
    TextView address;
    @BindView(R.id.distance)
    TextView distance;

    public VenueHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(Venue data){
        name.setText(data.getName());
        address.setText(data.getLocation().getAddress());
        distance.setText(String.valueOf(data.getLocation().getDistance())+" m");
    }

}
