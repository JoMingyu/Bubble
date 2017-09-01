package com.bubble.swcamp.android.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bubble.swcamp.android.R;
import com.bubble.swcamp.android.activities.MyPreset;
import com.bumptech.glide.Glide;
import com.makeramen.roundedimageview.RoundedImageView;

/**
 * Created by geni on 2017. 9. 1..
 */

public class MyPresetAdapter extends RecyclerView.Adapter<MyPresetAdapter.ViewHolder> {
    Context mContext;
    public MyPresetAdapter(Context context){
        this.mContext = context;
    }

    @Override
    public MyPresetAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_preset_item, parent, false);
        return new MyPresetAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyPresetAdapter.ViewHolder holder, int position) {
        Glide.with(mContext).load(R.drawable.kyungsook).into(holder.presetPreview);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        RoundedImageView presetPreview;
        public ViewHolder(View itemView){
            super(itemView);
            this.presetPreview = (RoundedImageView) itemView.findViewById(R.id.preset_preview);
        }
    }
}
