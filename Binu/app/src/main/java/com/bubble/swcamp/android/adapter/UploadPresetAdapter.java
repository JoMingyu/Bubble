package com.bubble.swcamp.android.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bubble.swcamp.android.R;

/**
 * Created by geni on 2017. 9. 2..
 */

public class UploadPresetAdapter extends RecyclerView.Adapter<UploadPresetAdapter.ViewHolder> {
    public static int REQUEST_CODE=1;
    Context context;
    @Override
    public UploadPresetAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_photo_select, parent, false);
        context=parent.getContext();
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(UploadPresetAdapter.ViewHolder holder, int position) {
        holder.imageView.setImageResource(R.drawable.ic_camera_add);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doTakePhoto();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView imageView;
        public ViewHolder(View itemView){
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.cardview);
            imageView = (ImageView) itemView.findViewById(R.id.sample_image);
        }
    }

    public void doTakePhoto(){
        Intent intent=new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        ((Activity) context).startActivityForResult(intent,REQUEST_CODE);
    }
}
