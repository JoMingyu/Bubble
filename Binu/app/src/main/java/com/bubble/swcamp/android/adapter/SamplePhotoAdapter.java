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

    public SamplePhotoAdapter(Context mcontext, ArrayList<SampleImage> images){
        this.context=mcontext;
        this.arrayList=images;
    }

    @Override
    public SamplePhotoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.photo_choose_item,parent,false);
        context=parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SamplePhotoAdapter.ViewHolder holder, int position) {
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
        return arrayList.size();
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
