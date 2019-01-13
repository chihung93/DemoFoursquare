package com.henry.foursquare.common.bases;

import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Abstract AbsRecyclerAdapter created to be extended by every RecyclerView.Adapter.
 */

public abstract class BaseRecyclerAdapter<M, V extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<V> {

    protected List<M> data = new ArrayList<>();

    public List<M> getData() {
        return data;
    }

    @Override
    public abstract V onCreateViewHolder(ViewGroup viewGroup, int viewType);

    @Override
    public abstract void onBindViewHolder(V k, int position);

    @Override
    public int getItemCount() {
        return data.size();
    }

    public int getLastPosition() {
        int position = data.size() - 1;
        if (position < 0)
            position = 0;
        return position;
    }

    public void delete(int i) {
        data.remove(i);
        notifyItemRemoved(i);
        notifyItemRangeChanged(i, data.size());
    }

    public M getItem(int position) {
        return data.get(position);
    }

    public void moveData(int i, int loc) {
        move(data, i, loc);
        notifyItemMoved(i, loc);
    }

    private void move(List<M> data, int a, int b) {
        M temp = data.remove(a);
        data.add(b, temp);
    }

    private int getLocation(List<M> data, M entity) {
        for (int j = 0; j < data.size(); ++j) {
            M newEntity = data.get(j);
            if (entity.equals(newEntity)) {
                return j;
            }
        }
        return -1;
    }

    public void appendAllData(final List<M> data) {
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    public void appendAllData(final List<M> data, int atIndex) {
        // Add all items.
        for (int i = 0; i < data.size(); ++i) {
            append(atIndex, data.get(i));
        }
    }

    public void append(int i, M entity) {
        data.add(i, entity);
        notifyItemInserted(i);
    }

    public void append(M data) {
        this.data.add(data);
        notifyItemInserted(this.data.size() - 1);
    }

    public void initData(final List<M> data) {
        // Add all items.
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }
}
