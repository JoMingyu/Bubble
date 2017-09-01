package com.bubble.swcamp.android.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bubble.swcamp.android.R;
import com.bubble.swcamp.android.activities.Filter;
import com.bubble.swcamp.android.activities.PhotoFilter;
import com.bubble.swcamp.android.model.FilterItem;
import com.bubble.swcamp.android.utils.FilterItemCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dsm2016 on 2017-09-01.
 */

public class FilterAdapter extends RecyclerView.Adapter<FilterAdapter.ViewHolder> {

    private List<FilterItem> arrayList;
    private int count;
    private FilterItemCallback mfilterItemCallback;
    private static int lastPosition = -1;
    private Context context;



    public FilterAdapter(List<FilterItem> items, Context context){
        //this.mfilterItemCallback=filterItemCallback;
        this.arrayList=items;
        this.count=items.size();
        this.context=context;
    }


    @Override
    public FilterAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.filter_list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FilterAdapter.ViewHolder holder, final int position) {

        final FilterItem filterItem=arrayList.get(position);

        View view = LayoutInflater.from(context)
                .inflate(R.layout.activity_filter, null, false);
        final ImageView main_imageView= (ImageView) ((Activity)context).findViewById(R.id.main_image);
        holder.imageView.setImageBitmap(filterItem.bitmap);
        holder.imageView.setScaleType(ImageView.ScaleType.FIT_START);
        holder.textView.setText(arrayList.get(position).getTitle());
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                main_imageView.setImageBitmap(filterItem.filter.processFilter(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.test_image), 640, 640, false)));
                Log.d("--------","click");

            }

        });


    }


    @Override
    public int getItemCount() {
        return count;
    }



    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        View view;

        public ViewHolder(View view) {
            super(view);
            imageView=(ImageView) view.findViewById(R.id.filter_image);
            textView=(TextView)view.findViewById(R.id.filter_title);
            view=view.findViewById(R.id.layout_filter_main);
        }
    }
}