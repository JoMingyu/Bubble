package com.bubble.swcamp.android.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bubble.swcamp.android.R;

/**
 * Created by geni on 2017. 9. 1..
 */

public class MainFiltersAdapter extends RecyclerView.Adapter<MainFiltersAdapter.ViewHolder> {
    @Override
    public MainFiltersAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_filters, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MainFiltersAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(View v){
            super(v);
        }
    }
}
