package com.bubble.swcamp.android.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bubble.swcamp.android.adapter.MyPageAdapter;
import com.bubble.swcamp.android.R;
import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by geni on 2017. 9. 1..
 */

public class MyPage extends AppCompatActivity {
    private ImageView bgProfile;
    private CircleImageView bgCircleProfile;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_page);

        bgProfile = (ImageView)findViewById(R.id.bg_profile);
        bgCircleProfile = (CircleImageView)findViewById(R.id.bg_circle_profile);
        recyclerView = (RecyclerView)findViewById(R.id.my_page_items);

        recyclerView.setAdapter(new MyPageAdapter(getApplicationContext()));
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));

        Glide.with(getApplicationContext()).load(R.drawable.heize).into(bgProfile);
        Glide.with(getApplicationContext()).load(R.drawable.heize).into(bgCircleProfile);
    }
}
