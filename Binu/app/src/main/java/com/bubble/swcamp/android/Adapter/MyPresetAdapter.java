package com.bubble.swcamp.android.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bubble.swcamp.android.R;
import com.bubble.swcamp.android.activities.PresetDetail;
import com.bumptech.glide.Glide;
import com.google.gson.JsonObject;
import com.makeramen.roundedimageview.RoundedImageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by geni on 2017. 9. 1..
 */

public class MyPresetAdapter extends RecyclerView.Adapter<MyPresetAdapter.ViewHolder> {
    Context mContext;
    List<JsonObject> list;
    public MyPresetAdapter(Context context, List list){
        this.mContext = context;
        this.list = list;
    }

    @Override
    public MyPresetAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_preset_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyPresetAdapter.ViewHolder holder, final int position){
        Glide.with(mContext).load(R.drawable.kyungsook).into(holder.presetPreview);
        holder.presetItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, PresetDetail.class);
                intent.putExtra("preset_id", list.get(position).get("preset_id").getAsInt());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);
            }
        });
        holder.presetName.setText(list.get(position).get("title").toString());
        holder.whoosePreset.setText(list.get(position).get("nickname").toString());
        holder.uploadState.setText(list.get(position).get("uploaded").toString());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout presetItem;
        RoundedImageView presetPreview;
        TextView presetName;
        TextView whoosePreset;
        TextView uploadState;
        public ViewHolder(View itemView){
            super(itemView);
            this.presetItem = (LinearLayout) itemView.findViewById(R.id.presetItem);
            this.presetPreview = (RoundedImageView) itemView.findViewById(R.id.preset_preview);
            this.presetName = (TextView) itemView.findViewById(R.id.preset_name);
            this.whoosePreset = (TextView) itemView.findViewById(R.id.whoose_preset);
            this.uploadState = (TextView) itemView.findViewById(R.id.uploadState);
        }
    }
}
