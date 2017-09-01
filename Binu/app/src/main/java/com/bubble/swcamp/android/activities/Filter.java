package com.bubble.swcamp.android.activities;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.bubble.swcamp.android.R;


/**
 * Created by geni on 2017. 9. 1..
 */

public class Filter extends AppCompatActivity {
    private Button like, download;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filter);

        like = (Button) findViewById(R.id.like);
        download = (Button) findViewById(R.id.download);
    }

    public void setFilter(View v){
        switch (v.getId()){
            case R.id.download:
                like.setBackgroundResource(R.drawable.bg_rounded_stroke_btn);
                like.setTextColor(Color.parseColor("#7e57c2"));
                download.setBackgroundResource(R.drawable.bg_rounded_primary_dark);
                download.setTextColor(Color.parseColor("#ffffff"));
                break;
            case R.id.like:
                download.setBackgroundResource(R.drawable.bg_rounded_stroke_btn);
                download.setTextColor(Color.parseColor("#7e57c2"));
                like.setBackgroundResource(R.drawable.bg_rounded_primary_dark);
                like.setTextColor(Color.parseColor("#ffffff"));
                break;
            default: break;
        }
    }
}

