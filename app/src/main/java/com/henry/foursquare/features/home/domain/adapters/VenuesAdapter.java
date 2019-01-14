package com.henry.foursquare.features.home.domain.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.henry.foursquare.R;
import com.henry.foursquare.common.bases.BaseRecyclerAdapter;
import com.henry.foursquare.data.models.Venue;
import com.henry.foursquare.features.home.domain.holders.VenueHolder;

import androidx.annotation.NonNull;

public class VenuesAdapter extends BaseRecyclerAdapter<Venue,VenueHolder> {

    @Override
    public VenueHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        return new VenueHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_venue,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull VenueHolder holder, int position) {
        holder.bind(getItem(position));
    }
}
