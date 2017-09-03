package com.bubble.swcamp.android.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bubble.swcamp.android.R;
import com.bubble.swcamp.android.activities.BubbleMarket;

/**
 * Created by geni on 2017. 9. 1..
 */

public class BubbleMarketAdapter extends RecyclerView.Adapter<BubbleMarketAdapter.ViewHolder> {
    Context mContext;
    public BubbleMarketAdapter(Context context){
        this.mContext = context;
    }

    @Override
    public BubbleMarketAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.bubble_market_items, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(BubbleMarketAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(View v){
            super(v);
        }
    }
}
