package com.bubble.swcamp.android.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bubble.swcamp.android.R;

/**
 * Created by geni on 2017. 9. 1..
 */

public class UploadedPresetAdapter extends RecyclerView.Adapter<UploadedPresetAdapter.ViewHolder> {
    @Override
    public UploadedPresetAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.uploaded_preset_items, parent, false);
        return new UploadedPresetAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(UploadedPresetAdapter.ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(View itemView){
            super(itemView);
        }
    }
}
