package com.bubble.swcamp.android.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bubble.swcamp.android.R;
import com.bumptech.glide.Glide;

/**
 * Created by geni on 2017. 9. 1..
 */

public class MyPageAdapter extends RecyclerView.Adapter<MyPageAdapter.ViewHolder> {
    Context mContext;

    public MyPageAdapter(Context context){
        this.mContext = context;
    }

    @Override
    public MyPageAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_page_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyPageAdapter.ViewHolder holder, int position) {
        switch (position){
            case 0:
                holder.itemName.setText("소유 마일리지");
                holder.itemName.setTextColor(Color.parseColor("#66BB6A"));
                holder.aboutItem.setText("현재까지 적립된 마일리지 내역입니다.");
                holder.line.setBackgroundColor(Color.parseColor("#66BB6A"));
                holder.bgColor.setBackgroundTintList(ContextCompat.getColorStateList(mContext, R.color.colorMyPageResA));
                holder.icon.getLayoutParams().width = 70;
                break;
            case 1:
                holder.itemName.setText("누적 좋아요");
                holder.itemName.setTextColor(Color.parseColor("#42A5F5"));
                holder.aboutItem.setText("현재까지 누적된 좋아요 횟수입니다.");
                holder.line.setBackgroundColor(Color.parseColor("#42A5F5"));
                holder.bgColor.setBackgroundTintList(ContextCompat.getColorStateList(mContext, R.color.colorMyPageResB));
//                holder.icon.setMaxWidth(50);
                break;
            case 2:
                holder.itemName.setText("프리셋 생성");
                holder.itemName.setTextColor(Color.parseColor("#EF5350"));
                holder.aboutItem.setText("현재까지 생성하신 프리셋 개수입니다.");
                holder.line.setBackgroundColor(Color.parseColor("#EF5350"));
                holder.bgColor.setBackgroundTintList(ContextCompat.getColorStateList(mContext, R.color.colorMyPageResC));
                break;
            case 3:
                holder.itemName.setText("프리셋 업로드");
                holder.itemName.setTextColor(Color.parseColor("#AB47BC"));
                holder.aboutItem.setText("현재까지 누적된 프리셋 업로드 갯수입니다.");
                holder.line.setBackgroundColor(Color.parseColor("#AB47BC"));
                holder.bgColor.setBackgroundTintList(ContextCompat.getColorStateList(mContext, R.color.colorMyPageResD));
                break;
            case 4:
                holder.itemName.setText("프리셋 다운로드");
                holder.itemName.setTextColor(Color.parseColor("#FF7043"));
                holder.aboutItem.setText("현재까지 누적된 프리셋 다운로드 갯수입니다.");
                holder.line.setBackgroundColor(Color.parseColor("#FF7043"));
                holder.bgColor.setBackgroundTintList(ContextCompat.getColorStateList(mContext, R.color.colorMyPageResE));
                break;
            case 5:
                holder.itemName.setText("내 프리셋 다운로드");
                holder.itemName.setTextColor(Color.parseColor("#8D6E63"));
                holder.aboutItem.setText("현재까지 누적된 내 프리셋 다운로드 수입니다.");
                holder.line.setBackgroundColor(Color.parseColor("#8D6E63"));
                holder.bgColor.setBackgroundTintList(ContextCompat.getColorStateList(mContext, R.color.colorMyPageResF));
                break;

        }
        Glide.with(mContext).load(R.drawable.ic_my_page1+position).into(holder.icon);
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView value;
        TextView itemName;
        View line;
        TextView aboutItem;
        RelativeLayout bgColor;
        ImageView icon;
        public ViewHolder(View itemView) {
            super(itemView);
            this.value = (TextView) itemView.findViewById(R.id.value);
            this.itemName = (TextView) itemView.findViewById(R.id.item_name);
            this.line = itemView.findViewById(R.id.line);
            this.aboutItem = (TextView) itemView.findViewById(R.id.about_item);
            this.bgColor = (RelativeLayout) itemView.findViewById(R.id.bg_color);
            this.icon = (ImageView) itemView.findViewById(R.id.icon);
        }
    }

}
