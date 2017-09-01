package com.bubble.swcamp.android.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bubble.swcamp.android.R;
import com.bumptech.glide.Glide;
import com.makeramen.roundedimageview.RoundedImageView;

/**
 * Created by geni on 2017. 9. 1..
 */

public class MainFiltersAdapter extends RecyclerView.Adapter<MainFiltersAdapter.ViewHolder> {
    Context mContext;

    public MainFiltersAdapter(Context context){
        this.mContext = context;
    }

    @Override
    public MainFiltersAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_filters, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MainFiltersAdapter.ViewHolder holder, int position) {
        switch (position){
            case 0:
                holder.preset_name.setText("런던브릿지");
                holder.whoose_preset.setText("");
                holder.download_count.setText("23");
                Glide.with(mContext).load(R.drawable.main_ex1).centerCrop().into(holder.presetPreview);
                break;
            case 1:
                holder.preset_name.setText("뉴욕");
                holder.whoose_preset.setText("");
                holder.download_count.setText("47");
                Glide.with(mContext).load(R.drawable.main_ex2).centerCrop().into(holder.presetPreview);
                break;
            case 2:
                holder.preset_name.setText("파리");
                holder.whoose_preset.setText("");
                holder.download_count.setText("15");
                Glide.with(mContext).load(R.drawable.main_ex3).centerCrop().into(holder.presetPreview);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        RoundedImageView presetPreview;
        TextView preset_name;
        TextView whoose_preset;
        TextView download_count;
        public ViewHolder(View v){
            super(v);
            this.presetPreview = (RoundedImageView)v.findViewById(R.id.preset_preview);
            this.preset_name = (TextView)v.findViewById(R.id.preset_name);
            this.whoose_preset = (TextView)v.findViewById(R.id.whoose_preset);
            this.download_count = (TextView)v.findViewById(R.id.download_count);
        }
    }
}
