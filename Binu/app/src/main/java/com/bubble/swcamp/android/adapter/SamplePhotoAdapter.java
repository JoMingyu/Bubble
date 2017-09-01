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
import com.bubble.swcamp.android.model.SampleImage;

import java.util.ArrayList;

/**
 * Created by dsm2016 on 2017-09-01.
 */

public class SamplePhotoAdapter extends RecyclerView.Adapter<SamplePhotoAdapter.ViewHolder>{

    ArrayList<SampleImage> arrayList;
    public static int REQUEST_CODE=1;
    Context context;
    Intent mIntent;

    public SamplePhotoAdapter(Context mContext){
        this.context=mContext;
    }

    @Override
    public SamplePhotoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.photo_choose_item,parent,false);
        context=parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SamplePhotoAdapter.ViewHolder holder, final int position) {
        //holder.imageView.setImageResource(R.drawable.ic_camera_add);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doTakePhoto();
            }
        });

        switch (position){
            case 0:
                holder.imageView.setImageResource(R.drawable.ic_camera_add);
                holder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        doTakePhoto();
                    }
                });
                break;
            case 1:
                holder.imageView.setImageResource(R.drawable.ic_camera_add);
                holder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        doTakePhoto();
                    }
                });
                break;
            case 2:
                holder.imageView.setImageResource(R.drawable.ic_camera_add);
                holder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        doTakePhoto();
                    }
                });
                break;
            case 3:
                holder.imageView.setImageResource(R.drawable.ic_camera_add);
                holder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        doTakePhoto();
                    }
                });
                break;
            case 4:
                holder.imageView.setImageResource(R.drawable.ic_camera_add);
                holder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        doTakePhoto();
                    }
                });
                break;
            case 5:
                holder.imageView.setImageResource(R.drawable.ic_camera_add);
                holder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        doTakePhoto();
                    }
                });
                break;
            case 6:
                holder.imageView.setImageResource(R.drawable.ic_camera_add);
                holder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        doTakePhoto();
                    }
                });
                break;
            case 7:
                holder.imageView.setImageResource(R.drawable.ic_camera_add);
                holder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        doTakePhoto();
                    }
                });
                break;
            case 8:
                holder.imageView.setImageResource(R.drawable.ic_camera_add);
                holder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        doTakePhoto();
                    }
                });
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 9;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        ImageView imageView;

        public ViewHolder(View view) {
            super(view);
            imageView=(ImageView)view.findViewById(R.id.sample_image);
            cardView=(CardView)view.findViewById(R.id.cardview);
        }
    }

    public void doTakePhoto(){
        Intent intent=new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        ((Activity) context).startActivityForResult(intent,REQUEST_CODE);
    }
}
