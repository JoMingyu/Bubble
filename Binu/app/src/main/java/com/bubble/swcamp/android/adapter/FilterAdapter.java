package com.bubble.swcamp.android.adapter;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bubble.swcamp.android.R;
import com.bubble.swcamp.android.activities.Filter;
import com.bubble.swcamp.android.model.FilterItem;

import java.util.ArrayList;

/**
 * Created by dsm2016 on 2017-09-01.
 */

public class FilterAdapter extends RecyclerView.Adapter<FilterAdapter.ViewHolder> {

    private ArrayList<FilterItem> arrayList;
    private Context context;

    public FilterAdapter(Context context,ArrayList<FilterItem> items){
        this.context=context;
        this.arrayList=items;
    }

    @Override
    public FilterAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.filter_list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FilterAdapter.ViewHolder holder, int position) {
        holder.imageView.setImageResource(arrayList.get(position).getImage());
        holder.textView.setText(arrayList.get(position).getTitle());


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public ViewHolder(View view) {
            super(view);
            imageView=(ImageView) view.findViewById(R.id.filter_image);
            textView=(TextView)view.findViewById(R.id.filter_title);
        }
    }
}
